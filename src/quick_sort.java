import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args){
        int[] arr={8,6,2,87,14,18,9,10};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }

        int low = start;
        int high = end;
        int mid = low+(high-low)/2;
        int pivot = arr[mid];

        while(low<=high){
            while(arr[low]<pivot){
                low++;
            }
            while(arr[high]>pivot){
                high--;
            }
            if(low<=high){
                int temp=arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
                low++;
                high--;
            }
        }
        sort(arr,low,end);
        sort(arr,start,high);

    }
}
