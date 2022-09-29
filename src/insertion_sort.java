import java.util.Arrays;

public class insertion_sort {
    public static void main(String[] args) {
        int[] arr={12,4,13,54,76,5,9,87,2,1};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertion(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(Arrays.toString(arr));
            for (int j = i+1; j > 0; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
                else{
                    break;
                }
            }
        }
    }

    static void swap(int[] arr,int first,int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
    }
}
