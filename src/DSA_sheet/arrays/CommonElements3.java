package DSA_sheet.arrays;

import java.util.ArrayList;

public class CommonElements3 {
    public static void main(String[] args) {
        int[] a = {1, 5, 10, 20, 40, 80};
        int[] b = {6, 7, 20, 80, 100};
        int[] c = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(commonElements(a, b, c));
    }

    static ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> res = new ArrayList<>();
        int n1 = a.length, n2 = b.length, n3 = c.length;
        int j = 0, i = 0, k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                if(!res.contains(a[i])) res.add(a[i]);
                if (i < n1 - 1 && a[i] == a[i + 1]) {
                    i++;
                } else if (j < n2 - 1 && b[j] == b[j + 1]) {
                    j++;
                } else if (k < n3 - 1 && c[k] == c[k + 1]) {
                    k++;
                }
                i++;
                j++;
                k++;
            } else if (a[i] < b[j] || a[i] < c[k]) {
                i++;
            } else if (b[j] < a[i] || b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return res;
    }
}
