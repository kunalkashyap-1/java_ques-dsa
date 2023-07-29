package DSA_sheet;
import java.util.*;

public class max_and_min_array {
    public static void main(String[] args){
        int[] arr={22,3,5,4,-1,7,6,8,44};
        System.out.println(Arrays.toString(min_max(arr)));
    }
    static int[] min_max(int[] arr){
        int[] res={0,0};
        if(arr.length == 1){
            res[0]=arr[0];
            res[1]=arr[0];
            return res ;
        }
            if(arr[0]>arr[1]){
                res[0]=arr[1];
                res[1]=arr[0];
            }
            else{
                res[1]=arr[1];
                res[0]=arr[0];
            }

        for(int i=2;i<arr.length;i++ ){
            if(arr[i]>res[1]){
                res[1]=arr[i];
            }
            if(arr[i]<res[0]){
                res[0]=arr[i];
            }
        }
        return res;
    }
}
