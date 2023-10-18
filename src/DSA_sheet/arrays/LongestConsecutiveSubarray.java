package DSA_sheet.arrays;
import java.util.HashSet;
public class LongestConsecutiveSubarray {
    public static void main(String[] args) {
        int[] arr = {1,9,3,10,4,20,2};
        System.out.println(findLongestConseqSubseq(arr,arr.length));
    }

    static int findLongestConseqSubseq(int[] arr, int N)
    {
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0;

        for(int item : arr){
            set.add(item);
        }

        for(int num : arr){
            if(!set.contains(num-1)){
                int currNum = num;
                int currLen = 1;

                while(set.contains(currNum +1)){
                    currNum++;
                    currLen++;
                }
                maxLength = Math.max(currLen, maxLength);
            }
        }
        return maxLength;
    }
}

