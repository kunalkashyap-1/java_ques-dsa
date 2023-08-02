package DSA_sheet.matrix;

public class row_max_1 {
    public static void main(String[] args){
        int[][] Arr= {{0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}};
        System.out.println(max1(Arr));
    }

    static int max1(int[][] mat){
        int i= mat.length;;
        if (i == 0) {
            return -1;
        }
        int j = mat[0].length;
        int row =0, col = j-1;
        int max_row_index = -1, max_ones = 0, curr_ones=0;
        while (row<i && col >=0){
                if(mat[row][col] == 1 ){
                    curr_ones++;
                    col--;
                    if(curr_ones>max_ones){
                        max_ones = curr_ones;
                        max_row_index = row;
                    }
                }else {
                    row++;
//                    curr_ones = 0;
                }
        }
        return max_row_index;
    }
}
