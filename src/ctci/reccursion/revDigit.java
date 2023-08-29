package ctci.reccursion;

public class revDigit {
    public static void main(String[] args) {
        System.out.println(rev(1223));
        System.out.println(palindrome(1221));
    }

    static int rev(int n) {
        if ((n % 10) == n) return n;
        return (int)((n % 10)*Math.pow(10,noArgs(n)-1)) + (rev(n / 10));
    }

    static int noArgs(int n){
        return (int)Math.log10(n) +1;
    }
    static boolean palindrome(int n){
        return n == rev(n);
    }
}
