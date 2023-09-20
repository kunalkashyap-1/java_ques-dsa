package ctci.arraysandString;

import java.util.ArrayList;

public class EqualToIndex {
    public static void main(String[] args) {
        int[] arr = {625, 538, 549, 484, 596, 42, 603, 351, 292, 10};
        System.out.println(find(arr));
    }
    static ArrayList<Integer> find(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i<= arr.length; i++){
            if(arr[i-1] == i){
                res.add(i);
            }
        }
        return res;
    }
}
