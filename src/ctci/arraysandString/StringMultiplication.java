package ctci.arraysandString;

import java.util.Arrays;

public class StringMultiplication {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(mult(num1, num2));
    }

    static String mult(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[m + n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];

                res[i + j] += sum / 10;//carry
                res[i + j + 1] = sum % 10;//current digit
            }
        }
        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int digit : res) {
            if (digit != 0) {
                leadingZero = false;
            }
            if (!leadingZero) {
                sb.append(digit);
            }
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }

}
