import java.util.Arrays;

public class set_mismatch {
    public static void main(String[] args) {
        int[] arr={8,7,3,5,3,6,1,4};
        System.out.println(Arrays.toString(missing(arr)));
    }

    static int[] missing(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
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
            if(arr[j]!=j+1){
                return new int[]{arr[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }

    static void swap(int[] arr,int first,int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
        System.out.println(Arrays.toString(arr));
    }
}


