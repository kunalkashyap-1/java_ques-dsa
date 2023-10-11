package DSA_sheet.string;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "axxzxy";
        System.out.println(find(str));
    }

    static int find(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for (int i = 0; i < str.length(); i++) dp[i][0] = 0;
        for (int i = 0; i < str.length(); i++) dp[0][i] = 0;

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= str.length(); j++) {
                //do lcs of the string with itself but don't include the one's with same index
                if(str.charAt(i-1) == str.charAt(j-1) && i!=j ){
                    dp[i][j] =1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[str.length()][str.length()];
    }
}
