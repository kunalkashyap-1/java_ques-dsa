public class no_of_digits {
    public static void main(String[] args) {
        int n=8954379;
        int b=32;
        int ans= (int) (Math.log(n)/Math.log(b)+1);
        System.out.println(ans);
    }
}
