package DSA_sheet.arrays;
import java.util.*;
public class union_two_arrays {
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 6};
        System.out.println(size_union(arr1, arr2));
    }
    static int size_union(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> h  = new HashMap<>();
        int i= arr1.length -1;
        int j = arr2.length -1;
        for(int x : arr1){
            if(!h.containsKey(x)){
                h.put(x,1);
            }
        }
        for(int x : arr2){
            if(!h.containsKey(x)){
                h.put(x,1);
            }
        }
        return h.size();
    }
}
