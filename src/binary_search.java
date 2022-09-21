import java.util.Arrays;
import java.util.Scanner;

public class binary_search {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i]=input.nextInt();
        }
        System.out.println("Enter target ");
        int target=input.nextInt();
        Arrays.sort(arr);
        System.out.println(bin_sear(arr,target));
    }
    static boolean bin_sear(int[] arr, int target){
        int first=0;
        int last=arr.length-1;
        while(first<=last){
            int mid=first+(last-first)/2;
            if(arr[mid]==target){
                return true;

            }
            else if (arr[mid]>target) {
                last=mid-1;
            }
            else{
                first=mid+1;
            }
        }
        return false;
    }
}
