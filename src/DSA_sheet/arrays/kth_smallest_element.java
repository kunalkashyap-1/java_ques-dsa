package DSA_sheet.arrays;
import java.util.*;

public class kth_smallest_element {
    public static void main(String[] args){
        // Initialize an array of integers
        int[] arr= {7, 10, 4, 3, 20, 15};
        // Define the value of k
        int k = 4;

        // Call the quickSelect method to find the kth smallest element
        System.out.println(quickSelect(arr, k - 1, 0, arr.length - 1));

        // Sort the array using Java's built-in sorting method
        Arrays.sort(arr);

        // Print the kth smallest element (Java's sorted array)
        System.out.println(arr[k - 1]);
    }

    // Method to perform quick selection to find the kth smallest element
    static int quickSelect(int[] arr, int k, int l, int r) {
        // Base case: if the left and right indices are the same, return the element at that index
        if (l == r) return arr[l];

        // Partition the array and get the index of the pivot element
        int pivotIndex = partition(arr, l, r);

        // Check if the pivotIndex is equal to k; if so, return the kth smallest element
        if (pivotIndex == k) return arr[k];
            // If pivotIndex is less than k, search in the right subarray
        else if (pivotIndex < k) return quickSelect(arr, k, pivotIndex + 1, r);
            // If pivotIndex is greater than k, search in the left subarray
        else return quickSelect(arr, k, l, pivotIndex - 1);
    }

    // Method to partition the array and place elements less than or equal to the pivot on the left
    // and elements greater than the pivot on the right
    static int partition(int[] arr, int l, int r){
        // Choose the last element (r) as the pivot
        int pivot = arr[r];

        // Initialize the index i to track the position for the pivot element
        int i = l - 1;

        // Iterate through the array from l to r-1
        for (int j = l; j < r; j++) {
            // If the current element is less than or equal to the pivot, swap it with the element at index i+1
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // Swap the pivot element with the element at index i+1 to place it in its correct position
        swap(arr, i + 1, r);
        System.out.println(Arrays.toString(arr));

        // Return the index of the pivot element after partitioning
        return i + 1;
    }

    // Method to swap two elements in the array
    static void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
