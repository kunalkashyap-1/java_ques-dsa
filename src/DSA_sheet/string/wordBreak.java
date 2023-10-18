package DSA_sheet.string;

import java.util.ArrayList;
import java.util.Collections;

public class wordBreak {
    public static void main(String[] args) {
        String str = "ilike";
        String[] dictionary = {"i", "like", "sam",
                "sung", "samsung", "mobile",
                "ice", "cream", "icecream",
                "man", "go", "mango"};
        ArrayList<String> dict = new ArrayList<>();
        Collections.addAll(dict, dictionary);
        System.out.println(check(str, dict));
    }

    static int check(String str, ArrayList<String> dict) {
        int n = str.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // An empty string can always be segmented

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If dp[j] is true and the substring from j to i is in the dictionary
                if (dp[j] && dict.contains(str.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n] ? 1 : 0;
    }
}
