package ctci.sorting_searches;

import java.util.Arrays;

public class sorts {
    public static void main(String[] args) {
        int[] arr = {1, 6, 23,5 , 7, 9, 43, 3, 0};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr) {
        for (int i = arr.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] =arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
