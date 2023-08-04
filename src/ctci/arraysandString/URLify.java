package ctci.arraysandString;

public class URLify {
    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        System.out.println(convert(s));
    }
    static String convert(String s){
        s=s.trim();
        StringBuilder str = new StringBuilder(s);
        String rep = "%20";
        for(int i = 0; i<str.length()-1; i++){
            if(str.charAt(i) == ' '){
                str.delete(i,i+1);
                str.insert(i,rep);
            }
        }
        return str.toString();
    }
}
