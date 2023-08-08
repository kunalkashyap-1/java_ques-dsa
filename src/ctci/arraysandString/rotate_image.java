package ctci.arraysandString;

import java.util.Arrays;

public class rotate_image {
    public static void main(String[] args) {
        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(arr);
        for(int r =0; r<arr.length; r++){
            System.out.println(Arrays.toString(arr[r]));
        }
    }
    static void rotate(int[][] arr){
        //transpose logic
        for(int i=0; i<arr.length;i++){
            for(int j=i+1; j<arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j]= arr[j][i];
                arr[j][i] =  temp;
            }
        }

        //reverse logic
        int i=0;
        int j= arr.length-1;
        while(i<j){
            for(int k=0; k<arr[0].length; k++){
                int temp = arr[k][i];
                arr[k][i]= arr[k][j];
                arr[k][j] =  temp;
            }
            i++;
            j--;
        }
    }
}
