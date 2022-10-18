public class sum_of_digits {
    public static void main(String[] args){
        int n=505298;
        System.out.println(sum(n));
    }

    static int sum(int n){
        if(n==0){
            return 0;
        }
        int digit=n%10;
        n/=10;
        return digit+sum(n);
    }
}
