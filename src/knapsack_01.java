// A solution for the 0 - 1 Knapsack problem
// using dynamic programming
public class knapsack_01
{
    // A utility method, which returns
// the maximum of two integers a1 and a2
    public int maximum(int a1, int a2)
    {
        return (a1 > a2) ? a1 : a2;
    }
    // Returns the maximum value that can
// be put in a knapsack of capacity C
    public int maxValueKnapsack(int C, int[] w, int[] val, int l)
    {
        int j, wt;
        int[][] dp = new int[l + 1][C + 1];
// Filling the table dp[][] in the bottom-up manner
        for (j = 0; j <= l; j++)
        {
            for (wt = 0; wt <= C; wt++)
            {
                if (j == 0 || wt == 0)
                {
                    // base case
                    dp[j][wt] = 0;
                }
                else if (w[j - 1] <= wt)
                {
                    // similar the previous approach making two choices
                    // either exluding or including the items
                    dp[j][wt] = maximum(val[j - 1] + dp[j - 1][wt - w[j - 1]], dp[j - 1][wt]);
                }
                else
                {
                    // current capacity of the knapsack does not allow
                    // this item. The current value is equal to the previous value
                    dp[j][wt] = dp[j - 1][wt];
                }
            }
        }
        return dp[j - 1][C];
    }
    //  main method
    public static void main(String[][] args)
    {
// input arrays
        int[] values = new int[] { 100, 60, 120 };
        int[] weight = new int[] { 20, 10, 30 };
// capacity of the knapsack
        int C = 50;
// length of the input arrays
        int l = values.length;
// instantiating the class KnapsackExample
        knapsack_01 knapObj = new knapsack_01();
// invoking the method maxValueKnapsack()
        int maxVal = knapObj.maxValueKnapsack(C, weight, values, l);
// displaying the final result
        System.out.println("The maximum value is: " + maxVal);
    }
}