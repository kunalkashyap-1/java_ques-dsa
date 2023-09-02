package ctci.arraysandString;
import java.util.*;
public class string_compression {
    public static void main(String[] args) {
        String str = "aabcccadddd";
        System.out.println(helper(str));
    }

    // Define a static method named 'helper' that takes a String 'str' as input.
    static int helper(String str) {
        // Convert the input string into an array of characters.
        char[] chars = str.toCharArray();

        // Initialize variables for tracking the current character index (i),
        // the total number of characters in the input string (n),
        // and the index for the modified character array (j).
        int i = 0;
        int n = chars.length;
        int j = 0;

        // Check if the input string has only one character, in which case it cannot be compressed further.
        if (n == 1)
            return 1;

        // Start iterating through the characters in the input string.
        while (i < n) {
            // Initialize a variable 'count' to keep track of the number of consecutive identical characters.
            int count = 1;

            // Get the current character.
            char charac = chars[i];

            // Check if the next character is the same as the current character and count them.
            while (i + 1 < n && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }

            // If there is only one occurrence of the character, add it to the modified character array.
            if (count == 1) {
                chars[j++] = charac;
            } else {
                // If there are more than one consecutive occurrences of the character,
                // add the character followed by the count as a string to the modified array.
                if (count > 1) {
                    chars[j++] = charac;
                    String counterstring = count + "";

                    // Iterate through the digits of the count and add them to the modified array.
                    for (int r = 0; r < counterstring.length(); r++) {
                        chars[j++] = counterstring.charAt(r);
                    }
                }
            }
            // Move to the next character in the input string.
            i++;
        }
//        System.out.println(Arrays.toString(chars));
        // Return the length of the modified character array, which represents the length of the compressed string.
        return j;
    }

}
