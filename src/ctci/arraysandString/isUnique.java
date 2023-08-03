package ctci.arraysandString;
import java.util.*;

public class isUnique {
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
       System.out.println(check(nums));
    }

    static boolean check(int[] nums){
        HashSet<Integer> h = new HashSet<>();
        for (int i = 0; i<nums.length; i++){
            if(h.contains(nums[i])) return true;
            else{
                h.add(nums[i]);
            }
        }
        return false;
    }
}
