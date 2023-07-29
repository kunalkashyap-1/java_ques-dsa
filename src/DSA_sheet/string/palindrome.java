package DSA_sheet.string;

public class palindrome {
    public static void main(String[] args){
        String s = "abba";
        String str = "abcdecba";
        System.out.println(check(s.toCharArray()));
        System.out.println(check(str.toCharArray()));
    }
    static boolean check(char[] s){
        int i = 0;
        int j = s.length-1;
        while(i<j){
            if(s[i]!=s[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
