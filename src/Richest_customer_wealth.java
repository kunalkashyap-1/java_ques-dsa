public class Richest_customer_wealth {
    public static void main(String[] args){
        int[][] mat =  {{2,8,2},{7,1,3},{1,9,5}};
        System.out.println(wealth(mat));
    }

    static int wealth(int[][] mat){
        int high=Integer.MIN_VALUE;
        for (int[] arr :
                mat) {
            int temp = 0;
            for (int num :
                    arr) {
                temp+=num;
            }
            if(high<temp){
                high = temp;
            }
        }
        return high;
    }
}
