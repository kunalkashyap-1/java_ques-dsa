import java.util.*;

public class lucky_number {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumber(matrix));
    }

    static List<Integer> luckyNumber(int[][] arr){
        int m=arr.length;
        int n = arr[0].length;
        Set<Integer> min = new HashSet<>();
        Set<Integer> max = new HashSet<>();
        for (int i = 0; i<m; i++) {
            int small = arr[i][0];
            for (int j = 1; j < n; j++) {
                if (arr[i][j] < small) {
                    small = arr[i][j];
                }
            }
            min.add(small);
        }
        for(int i = 0; i<n ; i++){
            int large = arr[0][i];
            for(int j = 1;j<m ;j++){
                if(arr[j][i] > large){
                    large=arr[j][i];
                }
            }
            max.add(large);
        }

        System.out.println(min);
        System.out.println(max);
        Set<Integer> ln = new HashSet<>(min);
        ln.retainAll(max);
        List<Integer> ls= new ArrayList<>(ln);
        return ls;
    }
}
