package DSA_sheet.string;
import java.util.HashMap;

public class duplicate_and_count {
    public static void main(String[] args){
        char[] str = {'c','c','b','a','b','c'};
        HashMap<Character,Integer> h = new HashMap();
        for(char s : str){
            if(!h.containsKey(s)){
                h.put(s,1);
            }else{
                int count = h.get(s);
                h.put(s,count+1);
            }
        }
        System.out.println(h);
    }
}
