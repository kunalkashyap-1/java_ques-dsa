public class string_not_a {
    public static void main(String[] args){
        skip("abscabaabat","");
        System.out.println(skip2("abscabaabat"));
    }

    static void skip(String str,String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        if(ch == 'a'){
            skip(str.substring(1),ans);
        }
        else{
            skip(str.substring(1),ans+ch);
        }
    }

    static String skip2(String str){
        if(str.isEmpty()){
            return "";
        }
        char ch=str.charAt(0);
        if(ch == 'a'){
            return skip2(str.substring(1));
        }
        else{
            return ch + skip2(str.substring(1));
        }
    }
}
