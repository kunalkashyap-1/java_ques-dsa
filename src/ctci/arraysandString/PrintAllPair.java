package ctci.arraysandString;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllPair {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<int[]> res = pairs(arr);
        for (int[] Arr :
                res) {
            System.out.println(Arrays.toString(Arr));
        }
    }

    static ArrayList<int[]> pairs(int[] arr) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int j : arr) {
            for (int k : arr) {
                list.add(new int[]{j, k});
            }
        }
        return list;
    }
}
