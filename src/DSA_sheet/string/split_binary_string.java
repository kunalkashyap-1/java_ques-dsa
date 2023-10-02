package DSA_sheet.string;

public class split_binary_string {
    public static void main(String[] args) {
        String str1 = "0100110101";
        String str2 = "0000000000";
        System.out.println(noSubstring(str1));
        System.out.println(noSubstring(str2));
    }

    static int noSubstring(String str) {
        int count0 = 0; // Initialize a counter for '0' characters.
        int count1 = 0; // Initialize a counter for '1' characters.
        int res = 0;    // Initialize a result variable.

        // Iterate through each character in the input string.
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count0++; // Increment the '0' count when '0' is encountered.
            } else {
                count1++; // Increment the '1' count when '1' is encountered.
            }

            // Check if the counts of '0' and '1' are equal.
            // If they are, it means a balanced substring is found, so increment the result.
            if (count0 == count1) {
                res++;
            }
        }

        // If the total count of '0' and '1' characters is not equal,
        // the string cannot be split into balanced substrings, so return -1.
        if (count0 != count1) {
            return -1;
        }

        // Return the count of balanced substrings in the input string.
        return res;
    }

}
