package DSA_sheet.string;

import java.util.Arrays;

public class WordWrap {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2};
        int k = 4;
        int[][] dp = new int[nums.length][2001];

        for(int[] row: dp)
            Arrays.fill(row, -1);
        System.out.println(recc(0, k, nums, k, dp));
    }

    static int recc(int i, int rem, int[] nums, int k, int[][] dp) {
        if (i == nums.length) return 0;
        //if we have already calculated it return it.
        if (rem >= 0 && dp[i][rem] != -1) return dp[i][rem];

        //find answer
        int ans;
        //if the current word can't be put in the line
        if (nums[i] > rem) {
            ans = (rem + 1) * (rem + 1) + recc(i + 1, k - nums[i] - 1, nums, k, dp);
        } else {
            int choice1 = (rem + 1) * (rem + 1) + recc(i + 1, k - nums[i] -1, nums, k, dp);
            int choice2 = recc(i + 1, rem - nums[i] -1 , nums, k, dp);
            ans = Math.min(choice1, choice2);
        }
        if(rem >= 0) dp[i][rem] = ans;
        return ans;
    }
}
