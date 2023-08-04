package DSA_sheet.arrays;
import java.lang.*;

public class max_sum_contiguous {
    public static void main(String[] args) {
        int[] Arr = {-1,-2,-3,-4};
        System.out.println(kadanes(Arr));
    }

    static int kadanes(int[] arr){
        int sum = 0, Max = arr[0];
        for(int i =0; i<arr.length; i++){
            if(sum<0) sum=0;
            sum += arr[i];
            Max = Math.max(Max, sum);
        }
        return Max;
    }
}
