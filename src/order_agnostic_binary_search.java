import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class order_agnostic_binary_search {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i]=input.nextInt();
        }
        System.out.println("Enter target ");
        int target=input.nextInt();
        Arrays.sort(arr);
        Collections.reverse(Arrays.asList(arr));
        System.out.println(bin_sear(arr,target));
    }
    static boolean bin_sear(int[] arr, int target){
        int first=0;
        int last=arr.length-1;
        //find how the array is sorted
        boolean is_asc=arr[first]<arr[last];
        while(first<=last){
            int mid=first+(last-first)/2;
            if(arr[mid]==target){
                return true;
            }
            else if (is_asc){
                if (arr[mid]>target) {
                    last=mid-1;
                }
                else{
                    first=mid+1;
                }
            }
            else{
                if (arr[mid]>target) {
                    first=mid+1;
                }
                else{
                    last=mid-1;
                }
            }
        }
        return false;
    }
}
