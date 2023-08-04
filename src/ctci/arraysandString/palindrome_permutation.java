package ctci.arraysandString;
import java.util.*;

public class palindrome_permutation {
    public static void main(String[] args){
        String s1 = "carerac";
        String s2 = "code";
        System.out.println(check(s1));
        System.out.println(check((s2)));
    }
    static boolean check(String s){
        HashSet<Character> h = new HashSet<>();
        for(int i =0; i<s.length(); i++){
            if(h.contains(s.charAt(i))){
                h.remove(s.charAt(i));
                continue;
            }
            h.add(s.charAt(i));
        }
        System.out.println(h.toString());
        return h.size() <=1;
    }
}
