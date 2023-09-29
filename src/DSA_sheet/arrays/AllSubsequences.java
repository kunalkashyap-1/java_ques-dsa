package DSA_sheet.arrays;
import java.util.ArrayList;

public class AllSubsequences {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(subSeq("",str));
    }

    static ArrayList<String> subSeq(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        list.addAll(subSeq(p+up.charAt(0),up.substring(1)));
        list.addAll(subSeq(p,up.substring(1)));
        return list;
    }
}
