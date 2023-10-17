package DSA_sheet.arrays;

public class MaxProduct {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, -1, 0};
        System.out.println(maxProductB(arr, arr.length));
    }

    static long maxProduct(int[] arr, int n) {
        // code here
        long max = arr[0];
        long min = arr[0];
        long ans = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                long temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i], max * arr[i]);
            min = Math.min(arr[i], min * arr[i]);

            ans = Math.max(ans, max);
        }
        return ans;
    }

    static long maxProductB(int[] arr, int n) {
        long left = 1, right = 1;
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (left == 0) left = 1;
            if (right == 0) right = 1;

            left *= arr[i];
            right *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(left, right));
        }
        return ans;
    }
}
