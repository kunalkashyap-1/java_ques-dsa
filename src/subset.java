import java.util.ArrayList;
import java.util.Arrays;

public class subset {
    public static void main(String[] args){
        find_subsets("abc","");
        System.out.println(find_subsetsret("abc",""));
    }

    static void find_subsets(String str,String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return ;
        }
        char ch = str.charAt(0);
        find_subsets(str.substring(1),ans+ch);
        find_subsets(str.substring(1),ans);
    }

    static ArrayList<String> find_subsetsret(String str, String ans){
        if(str.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = find_subsetsret(str.substring(1),ans+ch);
        ArrayList<String> right = find_subsetsret(str.substring(1),ans);
        left.addAll(right);
        return left;
    }
}
