import java.util.Arrays;

public class recc_bubble_sort {
    public static void main(String[] args) {
        int[] arr={8,7,6,5,4,3,2,1};
        sort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort (int[] arr, int last,int start){
        if(last==0){
            return;
        }
        if(start<last) {
            if (arr[start] > arr[start + 1]) {
                int temp = arr[start];
                arr[start] = arr[start + 1];
                arr[start + 1] = temp;
            }
            sort(arr, last, start + 1);
        }
        else{
            sort(arr,last-1,0);
        }

    }
}
