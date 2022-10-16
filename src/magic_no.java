public class magic_no {
    public static void main(String[] args) {
        int n=3;
        int ans =0;
        int base=5;
        while(n>0){
            int last =n&1;
            n>>=1;
            ans+=last*base;
            base=base*5;
        }
        System.out.println(ans);
    }
}
