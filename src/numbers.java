public class numbers {
    public static void main(String[] args) {
        recc_func(100);
    }

    static void  recc_func(int n){
        if(n <1){
            return;
        }
        n--;
        System.out.println(n);
        recc_func(n);

    }
}
