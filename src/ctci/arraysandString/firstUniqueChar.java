package ctci.arraysandString;
import java.util.*;
public class firstUniqueChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(check(s));
    }

    static int check(String s){
        if(s.length()==1){
            return 0;
        }
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(h.containsKey(c)){
                int count = h.get(c);
                h.put(c,count+1);
            }else{
                h.put(c,1);
            }
        }
        for(int i =0; i< s.length(); i++){
            if(h.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
