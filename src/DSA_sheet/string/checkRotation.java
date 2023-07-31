package DSA_sheet.string;

public class checkRotation {
    public static void main(String[] args) {
    String str1 = "ABCD";
    String str2 = "CDAB";
    System.out.println(check(str1, str2));
    }

    static boolean check(String str1, String str2){
        return (str1.length() == str2.length()
                && (str1 +str1).contains(str2)
                );
    }
}
