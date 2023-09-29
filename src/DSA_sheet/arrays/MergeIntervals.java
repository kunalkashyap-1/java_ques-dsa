package DSA_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] arr: merge(intervals)
             ) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] merge(int[][] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();
        int[] currentInterval = arr[0];
        for (int i = 1; i < n; i++) {
            int[] interval = arr[i];
            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(interval[1], currentInterval[1]);
            } else {
                res.add(currentInterval);
                currentInterval = interval;
            }
        }
        res.add(currentInterval);
        return res.toArray(new int[res.size()][]);
    }
}
