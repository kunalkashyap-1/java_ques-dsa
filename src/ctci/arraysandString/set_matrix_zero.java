package ctci.arraysandString;

import java.util.Arrays;

public class set_matrix_zero {
    public static void main(String[] args) {
        int[][] arr ={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        set_zero(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    static void set_zero(int[][] arr){
        int row =arr.length;
        int col = arr[0].length;
        boolean flag = false;
        //make the first row and first col as flag
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if(arr[r][c] ==0){
                    arr[0][c] =0;
                    if(r>0) arr[r][0] =0;
                    else flag = true;
                }
            }
        }

        // traverse and according to those flags set zeros
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if(arr[0][c] == 0 || arr[r][0] == 0){
                    arr[r][c] = 0;
                }
            }
        }

        //cause we skipped over first row and col
        if(arr[0][0] == 0) for (int r = 0; r < row; r++) {
            arr[r][0] = 0;
        }

        if(flag) for (int c = 0; c < col; c++) {
            arr[0][c] = 0;
        }
    }
}
