package DSA_sheet.string;

import java.util.ArrayList;
import java.util.Collections;

public class permutaionOfString {
    public static void main(String[] args) {
        String str = "ABB";
        ArrayList<String> list = new ArrayList<>();
        permutation("",str,list);
        Collections.sort(list);
        System.out.println(list);

    }

    static void permutation(String p, String up, ArrayList<String> list){
        if(up.isEmpty()){
            if(!list.contains(p))list.add(p);
            return;
        }
        for(int i = 0; i < up.length(); i++){
            permutation(p+up.charAt(i),up.substring(0, i) + up.substring(i + 1),list);
        }
    }
}
