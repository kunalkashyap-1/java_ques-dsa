public class search_in_bitonic_array {
    public static void main(String[] args) {
        int[] arr={1,3,4,5,3,2,1};
        int target=2;
        int peak=peak_el(arr);
        int found=bin_sear(arr,target,0,peak);
        if(found!=-1){
            System.out.println(found);
        }else{
            System.out.println(bin_sear(arr,target,peak+1,arr.length-1));
        }
    }

    static int peak_el(int[] arr){
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

    static int bin_sear(int[] arr,int target,int start,int end){
        int mid;
        boolean IsAsc=arr[start]<arr[end];
        while(start<=end){
            mid=start+((end-start)/2);
            if(arr[mid]==target){
                return mid;
            }
            else if(IsAsc){
                if(arr[mid]>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(arr[mid]>target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
