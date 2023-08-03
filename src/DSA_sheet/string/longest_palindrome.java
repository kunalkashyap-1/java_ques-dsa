package DSA_sheet.string;

public class longest_palindrome {
    public static void main(String[] args){
        String S = "aaaabbaa";
        System.out.println(longestP(S));
    }
    static String longestP(String s){
        if(s==null || s.length() == 0){
            return "";
        }

        String S ="";

        for(int i =0; i<s.length(); i++){
            String str1 = expand(s,i,i);
            String str2 = expand(s,i,i+1);

            if(str1.length()>S.length()) S=str1;
            if(str2.length()>S.length()) S=str2;
        }
        return S;
    }

    static String expand(String s, int left, int right){
        while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
