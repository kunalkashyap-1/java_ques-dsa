package DSA_sheet.arrays;
import java.util.Scanner;

public class can_become_non_decreasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Size of the array
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            boolean result = canBecomeNonDecreasing(arr);
            System.out.println(result ? "true" : "false");
        }
    }
       static boolean canBecomeNonDecreasing(int[] arr) {
            int n = arr.length;
            int count = 0;

            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    count++;
                    if (count > 1) {
                        return false;
                    }

                    // Check if we can modify the array element to make it non-decreasing
                    if (i > 0 && arr[i + 1] < arr[i - 1]) {
                        arr[i + 1] = arr[i];
                    } else {
                        arr[i] = arr[i + 1];
                    }
                }
            }

            return true;
        }
        }