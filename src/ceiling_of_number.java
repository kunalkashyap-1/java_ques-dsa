import java.util.Arrays;

public class ceiling_of_number {
    public static void main(String[] args){
        int[] arr= {23,5634,6,34,32,12,7,9,17};
        int target=21;
        Arrays.sort(arr);
        for(int el:arr){
            System.out.print(el+" ");
        }
        System.out.println();
        System.out.println(ceiling_func(arr,target));
    }

    static int ceiling_func(int[] arr,int target){
        int start =0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return arr[mid];
            }
            if(arr[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return arr[start];//for finding the floor of a number return end
        
    }
}
