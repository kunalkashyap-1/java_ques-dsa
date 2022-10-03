public class palindrome_string {
    public static void main(String[] args){
        String str="abcdcbda";

        System.out.println(check(str));
    }

    static boolean check(String str){
        str=str.toLowerCase();

        for (int k = 0; k < str.length()/2; k++) {
            char i=str.charAt(k);
            char j=str.charAt(str.length()-1-k);
            if(i!=j){
                return false;
            }
        }
        return true;
    }
}
