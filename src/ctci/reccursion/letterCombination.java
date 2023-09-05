package ctci.recursion;

import java.util.ArrayList;
import java.util.List;

public class letterCombination {
    public static void main(String[] args) {
        System.out.println(combinationGenerator("", "23"));
    }

    static List<String> combinationGenerator(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';

        // Create a mapping of digits to their associated letters
        String[] digitToLetters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ArrayList<String> list = new ArrayList<>();

        if (digit == 0 || digit == 1) {
            // If the digit is 0 or 1, skip it and proceed with the rest of the input
            list.addAll(combinationGenerator(p, up.substring(1)));
        } else {
            String letters = digitToLetters[digit];
            for (int i = 0; i < letters.length(); i++) {
                char ch = letters.charAt(i);
                list.addAll(combinationGenerator(p + ch, up.substring(1)));
            }
        }

        return list;
    }
}
