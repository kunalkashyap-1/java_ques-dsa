package DSA_sheet.arrays;

public class ClimbingSteps {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(stepCount(n));
    }

    static int stepCount(int n) {
        return fib(n);
    }

    static int fib(int n) {
        int p1 = 1;
        int p2 = 1;

        for (int i = 2; i <= n; i++) {// equal to n because we need the fibo of (n+1) step counts
            int curr = p1+p2;
            p2=p1;
            p1=curr;
        }
        return p1;
    }
}
