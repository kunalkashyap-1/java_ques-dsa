package DSA_sheet.arrays;
import java.util.*;

public class move_negatives {
    public static void main(String[] args){
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void sort(int[] arr){
        int l=0, r= arr.length - 1, temp;
        while(l<=r){
            if(arr[l]>0 && arr[r]<0){
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] =temp;
                l++;
                r--;
            }else if(arr[l]<0 && arr[r]>0){
                r--;
            }else if(arr[l] < 0 && arr[r] < 0){
                l++;
            }
            else{
                l++;
                r--;
            }
        }
    }
}
