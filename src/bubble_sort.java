import java.util.Arrays;

public class bubble_sort {
    public static void main(String[] args) {
        int[] arr={12,4,13,54,76,5,9,87,2,1};
        bubble(arr);//inplace sort, stable sort
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr){
        boolean swapped;
        //run n-1 times
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped = true;
                }
            }
            if (!swapped) { // !false = true
                break;
            }
            //array after every individual pass
            System.out.println(Arrays.toString(arr));
        }
    }
}
