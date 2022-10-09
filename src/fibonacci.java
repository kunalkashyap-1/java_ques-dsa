public class fibonacci {
    public static void main(String[] args) {
        long ans=fibo(12);
        System.out.println(ans);
        System.out.println(fiboFormula(412));
    }

    static long fiboFormula(int n)
    {
        return (long)(Math.pow(((1+Math.sqrt(5))/2),n)/Math.sqrt(5));
    }
    static long fibo(int n){
        if(n<=1){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
}
