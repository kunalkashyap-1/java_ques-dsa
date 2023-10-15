package DSA_sheet.arrays;

import java.util.HashSet;

public class SubArray0Sum {
    public static void main(String[] args) {
        int[] arr= {4 ,2 ,-3 ,1 ,6};
        System.out.println(slidingWindow(arr,arr.length));
    }
    static boolean findsum(int[] arr,int n)
    {
        int currSum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if(currSum  == 0 || set.contains(currSum)) return true;

            set.add(currSum);
        }
        return false;
    }

    static boolean slidingWindow(int[] arr, int n){
        int left = 0;
        int right = 0;
        int currSum = arr[0];

        while (right < n) {
            if (currSum == 0) {
                return true;
            } else if (currSum < 0) {
                right++;
                if (right < n) {
                    currSum += arr[right];
                }
            } else {
                currSum -= arr[left];
                left++;
            }
        }
        return false;
    }
}
