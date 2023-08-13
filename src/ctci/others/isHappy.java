package ctci.others;

public class isHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(1111111));
    }
    static Boolean isHappy(int n){
        int slow = n;
        int fast = n;
        do{
            slow = helper(slow);
            fast = helper(helper(fast));
        }while(slow != fast);
        return slow == 1;
    }

    static int helper(int n){
        int sum =0;
        while (n != 0){
            int digit = n %10;
            sum += digit*digit;
            n = n/10;
        }
        return sum;
    }
}
