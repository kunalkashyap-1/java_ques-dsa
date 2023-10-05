package DSA_sheet.arrays;

import java.util.HashMap;
import java.util.Map;

public class countOfSumPairs {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        System.out.println(count(arr, 6));
    }

    static int count(int[] arr, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        for (int num : arr) {
            int target = k - num;
            if(freqMap.containsKey(target)){
                count += freqMap.get(target);
            }

            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        return count;
    }
}
