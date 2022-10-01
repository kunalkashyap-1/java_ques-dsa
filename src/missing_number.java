import java.util.Arrays;

public class missing_number {
    public static void main(String[] args){
        int[] arr={9,8,7,6,5,4,3,1,0};
        System.out.println(missing(arr));
    }

    static int missing(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i];
            if(correct==arr.length){
                i++;
                continue;
            }
            if(arr[i]!=arr[correct]){
                    swap(arr, i, correct);
            }
            else{
                i++;
            }
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j){
                return j;
            }
        }
        return -1;
    }

    static void swap(int[] arr,int first,int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
        System.out.println(Arrays.toString(arr));
    }
}
