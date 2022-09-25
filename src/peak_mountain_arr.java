public class peak_mountain_arr {
    //bitonic array
    public static void main(String[] args){
        int[] arr={0,3,10,11,7,6,5,2};
        System.out.print(bin_sear(arr));
    }

    static int bin_sear(int[] arr){
        int start=0;
        int end= arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}
