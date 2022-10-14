public class unique_no {
    public static void main(String[] args) {
        int[] arr={2,4,6,4,2,6,8,4,8,4,1,1,7};
        System.out.println(ans(arr));
    }
    static int ans(int[] arr){
        int unique=0;
        for (int x:arr) {
            unique^=x;
        }
        return unique;
    }
}
