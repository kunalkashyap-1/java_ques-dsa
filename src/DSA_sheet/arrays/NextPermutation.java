package DSA_sheet.arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2};
        int[] arr2 = {2, 1, 5, 4, 3, 0, 0};
        next(arr1);
        System.out.println(Arrays.toString(arr1));
        next(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    static void next(int[] arr) {
        if (arr.length <= 1) return;
        int index = -1;
        int j = arr.length - 1;

        //find the breakpoint -> the longest prefix match
        for (int i = j - 1; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }
        //find closest greater to value at index and swap
        for (int i = j; i >= 0; i--) {
//            if(index == -1) break;
            if (index != -1 && arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        //reverse the rest of the array
        index++;
        while (index <= j) {
            int temp = arr[index];
            arr[index] = arr[j];
            arr[j] = temp;
            j--;
            index++;
        }
    }
}
