import static java.lang.Math.max;

public class jump_game {
    public static void main (String[] args){
        int [] nums = {2,5,0,0};
        System.out.println(jumpGame(nums));
    }

    static boolean jumpGame(int[] arr){
        int n = arr.length;
        int reachable = 0;
        for(int i = 0; i<n ; i++){
            if(reachable < i){
                return false;
            }
            reachable = max(reachable, i + arr[i]);
        }
        return true;
    }
}
