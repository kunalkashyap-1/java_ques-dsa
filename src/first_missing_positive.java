import java.util.Arrays;

public class first_missing_positive {
    public static void main(String[] args) {
        int[] arr={7,8,9,11,12};
        System.out.println(missing(arr));
    }

    static int missing(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;

            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j+1){
                return j+1;
            }
        }
        return arr.length+1;
    }

    static void swap(int[] arr,int first,int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
        System.out.println(Arrays.toString(arr));
    }
}
