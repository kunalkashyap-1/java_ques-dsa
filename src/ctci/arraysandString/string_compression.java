package ctci.arraysandString;
import java.util.*;
public class string_compression {
    public static void main(String[] args) {
        String str = "aabcccadddd";
        System.out.println(helper(str));
    }

    static int helper(String str){
        char[] chars = str.toCharArray();
        int i=0;
        int n=chars.length;
        int j=0;
        if(n==1)
            return 1;
        while(i<n){
            int count=1;
            char charac=chars[i];
            while(i+1<n && chars[i]==chars[i+1]){
                count++;
                i++;
            }
            if(count==1){
                chars[j++]=charac;
            }
            else{
                if(count>1){
                    chars[j++]=charac;
                    String counterstring=count+"";
                    for(int r=0;r<counterstring.length();r++){
                        chars[j++]=counterstring.charAt(r);
                    }
                }
            }
            i++;
        }
        return j;
    }
}
