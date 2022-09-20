import java.util.Scanner;

public class linear_2d_array {
    public static void main(String[] args) {
        int [][] arr={
                {25,4,2},
                {1,3,7,9},
                {9,7},
                {18,12}};
        System.out.println("enter target to be searched");
        Scanner input= new Scanner(System.in);
        int target=input.nextInt();
        System.out.println(linear_search_2d(arr,target));
    }

    static boolean linear_search_2d(int[][] arr,int target){
        for (int[] ints : arr) {
            for (int elInt : ints) {
                if (elInt == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
