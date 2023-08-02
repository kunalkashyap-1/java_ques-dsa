package DSA_sheet.string;

public class count_and_say {
    public static void main(String[] args){
        System.out.println(say(30));
    }

    static String say(int n){
        if(n==1) return "1";
        String s = "1";
        for(int i=1; i<n; i++) {
            s = count(s);
        }
        return s;
    }

    static String count(String s){
        StringBuilder res = new StringBuilder();
        char c = s.charAt(0);
        int freq = 1;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i) == c){
                freq++;
            }
            else{
                res.append(freq);
                res.append(c);
                c=s.charAt(i);
                freq=1;
            }
        }
        res.append(freq);
        res.append(c);

        return res.toString();
    }
}
