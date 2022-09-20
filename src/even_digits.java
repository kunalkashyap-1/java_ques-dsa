public class even_digits {
    public static void main(String[] args) {
        int[] nums={12,345,27,66,7896};
        System.out.println(find_number(nums));
    }
    static int find_number(int[] nums){
        int count=0;
        for (int el:nums)
             {
            if(even(el)){
                count++;
            }
        }
        return count;
    }
    static boolean even(int el){
        int no_of_digits=digits(el);
        return no_of_digits%2==0;
    }
    private static int digits(int el) {
        int count=0;
        if(el==0){
            return 1;
        }
        if(el<0){
            el=el*-1;
        }
        while(el>0){
            count++;
            el=el/10;
        }
        return count;
    }
}
