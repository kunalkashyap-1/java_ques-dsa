package DSA_sheet.matrix;

import java.util.*;

public class spiralTraversal {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int left = 0, right = mat[0].length;
        int top = 0, bottom = mat.length;
        ArrayList<Integer> res = new ArrayList<>();

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                res.add(mat[top][i]);
            }
            top++;

            for (int i = top; i < bottom; i++) {
                res.add(mat[i][right - 1]);
            }
            right--;

            if (!(left < right && top < bottom)) {
                break;
            }

            for (int i = right - 1; i >= left; i--) {
                res.add(mat[bottom - 1][i]);
            }
            bottom--;

            for (int i = bottom - 1; i >= top; i--) {
                res.add(mat[i][left]);
            }
            left++;
        }
        System.out.println(res.toString());
    }
}
