import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class find_all_duplicate {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        cyclic(nums);
        List<Integer> ans= new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                ans.add(nums[i]);
            }
        }
        System.out.println(ans);
    }

    static void cyclic(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
    }

    static void swap(int[] arr,int first,int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
        System.out.println(Arrays.toString(arr));
    }
}
