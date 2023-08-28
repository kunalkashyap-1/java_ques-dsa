package ctci.reccursion;

public class intro {
    public static void main(String[] args) {
        count_recc(0);
    }

    static void count_recc(int x){
        if(x == 10){
            return;
        }
        x++;
        count_recc(x);
        if(x%2 == 0){
            System.out.println(x);
            return;
        }
        System.out.println( x+1);
    }
}
