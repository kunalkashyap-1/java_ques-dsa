import java.util.Arrays;

public class find_duplicate {
    public static void main(String[] args) {
        int[] arr={1,2,2,4};
        System.out.println(cyclic(arr));
//        System.out.println(arr[arr.length-1]);

    }

    static int cyclic(int[] arr){
        int i=0;
        while(i<arr.length){
            if(arr[i]!=i+1){
                int correct = arr[i]-1;
                if(arr[i]!=arr[correct]){
                    swap(arr,i,correct);
                }
                else{
                    return arr[i];
                }
            }
            else{
                i++;
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
