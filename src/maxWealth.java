public class maxWealth {
    public static void main(String[] args){

    }
    public int maximumWealth(int[][] accounts) {
        int ans = -1;
        for (int[] ints : accounts) {
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }
}
