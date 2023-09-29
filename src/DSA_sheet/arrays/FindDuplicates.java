package DSA_sheet.arrays;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(find(arr));
    }

    static int find(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
//Detect cycle
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        int ptr1 = arr[0];
        int ptr2 = slow;
//Find the entrace of the cycle
        while (ptr1 != ptr2) {
            ptr1 = arr[ptr1];
            ptr2 = arr[ptr2];
        }

        return ptr1;
    }
}
