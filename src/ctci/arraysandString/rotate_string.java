package ctci.arraysandString;

public class rotate_string {
    public static void main(String[] args){
        String str1 = "abcde";
        String str2 = "cdeab";
        System.out.println(check(str1, str2));
    }

    static boolean check(String str1, String str2){
        if(str1.length() != str2.length()) return false ;
        int index = str2.lastIndexOf(str1.charAt(0));
        if(index == -1) return false;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt((index +i) % str1.length())) return false;
        }
        return true;
    }

    static boolean checkByConcat(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        String concatenated = str2 + str2;  // Concatenate str2 with itself

        return concatenated.contains(str1);  // Check if str1 is a substring of the concatenated string
    }
}
