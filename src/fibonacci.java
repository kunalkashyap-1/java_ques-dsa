public class fibonacci {
    public static void main(String[] args) {
        long ans=fibo(12);
        System.out.println(ans);
    }

    static long fibo(int n){
        if(n<=1){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
}
