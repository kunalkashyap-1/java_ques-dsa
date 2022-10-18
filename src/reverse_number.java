public class reverse_number {
    public static void main(String[] args){
        int n=903498;
        reverse_method_1(n);
        System.out.println(sum);
        int no_digit=(int)Math.log10(n);
        System.out.println(reverse_method_2(n,no_digit));
    }

    static int sum =0;
    static void reverse_method_1(int n){
        if(n==0){
            return;
        }
        int digit = n%10;
        sum=sum*10+digit;
        reverse_method_1(n/10);
    }

    static int reverse_method_2(int n,int no_digit){
        if(n==0){
            return 0;
        }
        int digit = n%10;
        return (int)(digit*Math.pow(10,no_digit))+reverse_method_2(n/10,--no_digit);
    }
}
