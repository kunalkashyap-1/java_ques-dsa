package DSA_sheet.arrays;
import java.util.*;

public class cyclic_rotate {
    public static void main(String[] args){
        int[] arr = {9, 8, 7, 6, 4, 2, 1, 3};
        int temp = arr[arr.length-1];
        for(int i=arr.length -1; i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        System.out.println(Arrays.toString(arr));
    }
}
