package DSA_sheet.arrays;

public class StocksProfit {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7,6,4,3,1};
        System.out.println(profit(prices1));
        System.out.println(profit(prices2));
    }

    static int profit(int[] arr) {
        int lsf = Integer.MAX_VALUE;//least so far
        int op = 0;//overall profit
        int pist = 0;//profit if we sold today
        for (int i = 0; i < arr.length; i++) {
            if(lsf > arr[i]) lsf= arr[i];
            pist = arr[i] - lsf;
            if(pist > op) op = pist;
        }
        return op;
    }
}
