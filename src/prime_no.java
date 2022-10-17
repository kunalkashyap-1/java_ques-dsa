public class prime_no {
    public static void main(String[] args) {
        int n=200;
//        System.out.println(method_1(n));

        boolean[] primes= new boolean[n+1];
        method_sieve(n,primes);
    }

    static boolean method_1(int n){
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    static void method_sieve(int n , boolean[] primes){
        for (int i = 2; i*i <=n; i++) {
            if(!primes[i]){
                for (int j = i*2; j <= n; j+=i) {
                    primes[j]=true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]){
                System.out.print(i+" ");
            }
        }
    }
}
