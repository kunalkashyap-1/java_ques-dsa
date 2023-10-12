package DSA_sheet.arrays;

public class AlternatePosNeg {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, -4, -1, 4};
        rearrange(arr1, arr1.length);
        System.out.print("Output: ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }

        int[] arr2 = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrange(arr2, arr2.length);
        System.out.println("\nOutput: ");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
    }

    // Utility function to right rotate all elements
    // between [outofplace, cur]
    static void rightrotate(int arr[], int n, int outofplace, int cur) {
        int tmp = arr[cur];
        for (int i = cur; i > outofplace; i--)
            arr[i] = arr[i - 1];
        arr[outofplace] = tmp;
    }

    static void rearrange(int arr[], int n) {
        int outofplace = -1;

        for (int index = 0; index < n; index++) {
            if (outofplace >= 0) {
                // find the item which must be moved into
                // the out-of-place entry if out-of-place
                // entry is positive and current entry is
                // negative OR if out-of-place entry is
                // negative and current entry is negative
                // then right rotate
                //
                // [...-3, -4, -5, 6...] -->   [...6, -3,
                // -4, -5...]
                //      ^                          ^
                //      |                          |
                //     outofplace      -->      outofplace
                //
                if (((arr[index] >= 0)
                        && (arr[outofplace] < 0))
                        || ((arr[index] < 0)
                        && (arr[outofplace] >= 0))) {
                    rightrotate(arr, n, outofplace, index);

                    // the new out-of-place entry is now 2
                    // steps ahead
                    if (index - outofplace >= 2)
                        outofplace = outofplace + 2;
                    else
                        outofplace = -1;
                }
            }

            // if no entry has been flagged out-of-place
            if (outofplace == -1) {
                // check if current entry is out-of-place
                if (((arr[index] >= 0)
                        && ((index & 0x01) == 0))
                        || ((arr[index] < 0)
                        && (index & 0x01) == 1))
                    outofplace = index;
            }
        }
    }
}
