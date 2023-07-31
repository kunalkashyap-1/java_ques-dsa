package DSA_sheet.matrix;

public class binarySearch2D {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 34;
        System.out.println(Search2D(matrix, target));
    }
    static boolean Search2D(int[][] matrix, int target){
        int rows= matrix.length, cols=matrix[0].length;
        int top=0;
        int bottom=rows-1;

        while(top<=bottom){
            int row = (top+bottom)/2;
            if(target > matrix[row][matrix[row].length-1]){
                top=row+1;
            }
            else if(target< matrix[row][0]){
                bottom = row-1;
            }
            else{
                break;
            }
        }

        if(!(top<=bottom)){
            return false;
        }
        int row = (top+bottom)/2;
        int l=0, r=cols-1;
        while(l<=r){
            int m=(l+r)/2;
            if(target >matrix[row][m]){
                l=m+1;
            }else if(target < matrix[row][m]){
                r=m-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
