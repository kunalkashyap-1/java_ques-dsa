package DSA_sheet.arrays;

import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collections;

public class LongFactorial {
    public static void main(String[] args) {
        int n = 982;
        System.out.println(factorial(n));
    }

//    static long fact(int n) {
//        long res = n;
//        while (n > 1) {
//            res *= --n;
//        }
//        return res;
//    }

    static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        int size = 1;
        for(int i =2; i<=n; i++){
            size = mult(res, i,size);
        }

        Collections.reverse(res);
        return res;
    }

    static int mult(ArrayList<Integer> list, int x, int size){
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int prod = list.get(i) * x +carry;
            list.set(i,prod%10);
            carry = prod/10;
        }

        while(carry != 0){
            list.add(carry % 10);
            carry/=10;
            size++;
        }
        return size;
    }
}
