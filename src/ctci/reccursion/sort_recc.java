package ctci.reccursion;

import java.util.Arrays;

public class sort_recc {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 2, 89, 7, 9};
//        bubble_recc(arr, 0, arr.length - 1);
        select_recc(arr,0, arr.length,0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble_recc(int[] arr, int n, int i) {
        if (i == 1) return;
        if (n < i) {
            if (arr[n] > arr[n + 1]) {
                int temp = arr[n];
                arr[n] = arr[n + 1];
                arr[n + 1] = temp;
            }
            bubble_recc(arr, n + 1, i);
        } else {
            bubble_recc(arr, 0, --i);
        }
    }

    static void select_recc(int[] arr, int p, int l, int max) {
        if(l == 0) return;
        if(p<l){
            if(arr[p] > arr[max]){
                select_recc(arr,p+1,l,p);
            }else{
                select_recc(arr,p+1,l,max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[l-1];
            arr[l-1] = temp;
            select_recc(arr,0,l-1,0);
        }
    }

}
