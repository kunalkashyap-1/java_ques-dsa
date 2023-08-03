package ctci.arraysandString;
import java.util.*;

public class permutaion_in_string {
    public static void main(String[] args){
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(check(s1,s2));
    }

    static boolean check(String s1, String s2){
        if(s1.length() > s2.length()) return false;

        HashMap<Character, Integer> str1Freq = createHashMap(s1);
        HashMap<Character, Integer> windowFreq = createHashMap(s2.substring(0,s1.length()));

        for(int i =0; i<=s2.length() -s1.length(); i++ ){
            if(str1Freq.equals(windowFreq)) return true;

            char leftChar = s2.charAt(i);
            windowFreq.put(leftChar, windowFreq.getOrDefault(leftChar,0)-1);
            if(windowFreq.get(leftChar) == 0) windowFreq.remove(leftChar);

            if(i + s1.length() < s2.length()){
                char rightChar= s2.charAt(i+s1.length());
                windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar,0)+1);
            }
        }
        return str1Freq.equals(windowFreq);
    }

    static HashMap<Character, Integer> createHashMap(String s){
        HashMap<Character,Integer> charFreq = new HashMap<>();
        for (char c: s.toCharArray()){
            charFreq.put(c, charFreq.getOrDefault(c,0)+1);
        }
        return charFreq;
    }
}
