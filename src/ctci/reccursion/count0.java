package ctci.reccursion;

public class count0 {
    public static void main(String[] args) {
        System.out.println(check(100020,0));
    }
    static int check(int n, int c){
        if(n == 0) return c;
        if(n%10 ==0)
        return check(n/10,c+1);
        return check(n/10,c);
    }
}
