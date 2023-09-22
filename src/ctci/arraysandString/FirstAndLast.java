package ctci.arraysandString;

import java.util.ArrayList;

public class FirstAndLast {
    public static void main(String[] args) {
        int[] arr = {1,3,5,5,5,5,7,123,125};
        System.out.println(find(arr,5));
    }
    static ArrayList<Integer> find(int[] arr, int x){
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-1);

        int left = 0;
        int right = arr.length -1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if(arr[mid] == x){
                res.set(0,mid);
                right = mid -1;
            }else if(arr[mid] < x){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }

        left = 0;
        right = arr.length -1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if(arr[mid] == x){
                res.set(1,mid);
                left = mid +1;
            }else if(arr[mid] < x){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return res;
    }
}
