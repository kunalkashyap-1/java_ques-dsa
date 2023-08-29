package ctci.reccursion;

import java.util.ArrayList;

public class arrRecc {
    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 8, 9, 12, 0, 1};
        System.out.println(checkIsSorted(0, arr));
        System.out.println(search(arr, 3, 0));
        System.out.println(findOccur(arr, 8, 0));
        System.out.println(rotatedBinarySearch(arr, 8, 0, arr.length));
    }

    static boolean checkIsSorted(int i, int[] arr) {
        if (arr.length - 1 == i) return arr[i] < arr[i + 1];
        return (arr[i] < arr[i + 1]) && checkIsSorted(++i, arr);
    }

    static boolean search(int[] arr, int t, int i) {
        if (arr.length == i) return false;
        return arr[i] == t || search(arr, t, ++i);
    }

    static ArrayList<Integer> findOccur(int[] arr, int t, int i) {
        ArrayList<Integer> list = new ArrayList<>();
        // Base case: if we have reached the end of the array, return an empty list
        if (arr.length - 1 == i) return list;
            // If the current element is equal to the target element, add its index to the list
        else if (arr[i] == t) list.add(i);
        // Recursively find occurrences of the target element in the rest of the array
        ArrayList<Integer> ansFromBelow = findOccur(arr, t, i + 1);
        // Add all occurrences found in the rest of the array to the list
        list.addAll(ansFromBelow);
        return list;
    }

    static int rotatedBinarySearch(int[] arr, int t, int s, int e) {
        // Base case: if the start index is greater than the end index, return -1 (element not found)
        if (s > e) return -1;
        // Calculate the middle index of the subarray being searched
        int mid = s + (e - s) / 2;
        // If the middle element is equal to the target element, return its index
        if (arr[mid] == t) return mid;
        // If the first half of the subarray is sorted
        if (arr[s] <= arr[mid]) {
            // If the target element lies within this sorted half, search this half recursively
            if (t >= arr[s] && t <= arr[mid]) {
                return rotatedBinarySearch(arr, t, s, mid - 1);
            } else {
                // Otherwise, search the other half recursively
                return rotatedBinarySearch(arr, t, mid + 1, e);
            }
        }
        // If the second half of the subarray is sorted and contains the target element,
        // search this half recursively
        if (t >= arr[mid] && t <= arr[e]) {
            return rotatedBinarySearch(arr, t, mid + 1, e);
        } else {
            // Otherwise, search the other half recursively
            return rotatedBinarySearch(arr, t, s, mid - 1);
        }
    }

}
