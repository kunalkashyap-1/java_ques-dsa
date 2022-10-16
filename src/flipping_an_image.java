import java.util.Arrays;

public class flipping_an_image {

    public static void main(String[] args) {
        int[][] arr={{1,1,0},{1,0,1},{0,0,0}};
        for(int[] row : arr) {
            // reverse this array
            for (int i = 0; i < (arr[0].length + 1) / 2; i++) {
                // swap
                int temp = row[i] ^ 1;
                row[i] = row[arr[0].length - i - 1] ^ 1;
                row[arr[0].length - i - 1] = temp;
            }
        }
        for (int[] n: arr) {
            System.out.println(Arrays.toString(n));
        }
    }
}
