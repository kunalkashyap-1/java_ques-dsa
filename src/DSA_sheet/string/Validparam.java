package DSA_sheet.string;

import java.util.Stack;

public class Validparam {
    public static void main(String[] args) {
        String str = "}{([])}";
        System.out.println(isValid(str));
    }

    static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket found
                }
                char top = stack.pop();
                if ((currentChar == ')' && top != '(') ||
                        (currentChar == '}' && top != '{') ||
                        (currentChar == ']' && top != '[')) {
                    return false; // Mismatched brackets
                }
            }
        }

        return stack.isEmpty();
    }
}
