import java.util.Arrays;

public class selection_sort {
    public static void main(String[] args){
        int[] arr={12,4,13,54,76,5,9,87,2,1};
        select(arr);//inplace sort, stable sort
        System.out.println(Arrays.toString(arr));
    }

    static void select(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last=arr.length-i-1;
            int maxIndex=getMaxIndex(arr,0,last);

            swap(arr,maxIndex,last);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int max=start;

        for (int i = start; i <= end; i++) {
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }

    static void swap(int[] arr,int first,int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
        System.out.println(Arrays.toString(arr));
    }
}
