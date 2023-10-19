package DSA_sheet.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class ElementMoreThan_ak {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 5, 4,
                2, 2, 3, 1, 1, 1};
        int k = 4;
        System.out.println(find(arr,k));
    }

    static ArrayList<Integer> find(int[] arr, int k){
        int x = arr.length / k;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for( int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key) > x)list.add(key);
        }
        return list;
    }
}
