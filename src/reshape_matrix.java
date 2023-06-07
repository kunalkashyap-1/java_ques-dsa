import java.util.Arrays;

public class reshape_matrix {
    public static void main(String[] args){
        int[][] mat = {{1,2},{3,4}};
        int r=1, c=4;
        System.out.println(Arrays.deepToString(reshape(mat,r,c)));
    }

    static int[][] reshape(int[][] arr, int r, int c){
        int m=arr.length , n = arr[0].length;
        if(m*n != r*c) return arr;
        int[][] res = new int[r][c];
        int row=0,col=0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                res[row][col] = arr[i][j];
                col++;
                if(col == c){
                    col=0;
                    row++;
                }
            }
        }
        return res;
    }
}
