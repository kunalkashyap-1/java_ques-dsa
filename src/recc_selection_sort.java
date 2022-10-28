import java.util.Arrays;

public class recc_selection_sort {
    public static void main(String[] args){
        int[] arr={8,27,65,53,45,73,72,21};
        sort(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int last,int start,int max){
        if(last==0){
            return;
        }
        if(start<last){
            if(arr[start]>arr[max]){
                sort(arr,last,start+1,start);
            }else {
                sort(arr,last,start+1,max);
            }
        }else{
            int temp= arr[last-1];
            arr[last-1]=arr[max];
            arr[max]=temp;
            sort(arr,last-1,0,0);
        }
    }
}
