package DSA_sheet.string;

public class EditDistance {
    public static void main(String[] args) {
        String s = "geek", t = "gesek";
        System.out.println(distanceCount(s,t));
    }
    static int distanceCount(String s, String t){
        int l1 = s.length();
        int l2 = t.length();
        int[][] dp = new int[l1 +1][l2+1];
        for (int i = 0; i <= l1; i++) dp[i][0] = i;
        for (int i = 0; i <= l2; i++) dp[0][i] = i;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[l1][l2];
    }
}
