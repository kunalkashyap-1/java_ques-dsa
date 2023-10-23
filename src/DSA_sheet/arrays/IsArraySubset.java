package DSA_sheet.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class IsArraySubset {
    public static void main(String[] args) {

    }

    static String isSubset( long a1[], long a2[], long n, long m) {
        ArrayList<Long> list = new ArrayList<>();
        for(Long num : a1){
            list.add(num);
        }

        for (long l : a2) {
            if (list.contains(l)) {
                list.remove(l);
            } else return "No";
        }
        return "Yes";
    }
}
