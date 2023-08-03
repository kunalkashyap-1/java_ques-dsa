package DSA_sheet.arrays;
import java.util.*;

public class kth_smallest_element {
    public static void main(String[] args){
        int[] arr= {7, 10, 4, 3, 20, 15};
        int k = 4;
//        k= arr.length-k +1;
        System.out.println(quickSelect(arr,k-1,0,arr.length-1));
        Arrays.sort(arr);
        System.out.println(arr[k-1]);
    }

    static int quickSelect(int[] arr, int k,int l, int r) {
        if (l == r) return arr[l];
        int pivotIndex = partition(arr, l, r);

        if (pivotIndex == k) return arr[k];
        else if (pivotIndex < k) return quickSelect(arr, k, pivotIndex + 1, r);
        else return quickSelect(arr, k, l, pivotIndex - 1);
    }

    static int partition(int[] arr ,int l, int r){
        int pivot = arr[r];
        int i = l-1;
        for(int j = l; j<r; j++){
            if(arr[j]<= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1,r);
        return i+1;
    }

    static void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
