public class binary_search_infinite_array {
    public static void main(String[] args){
        int[] nums={3, 5, 7, 9, 10, 90,100, 130, 140, 160, 170};
        int target=140;
        int start=0;
        int end=1;
        int ans=0;
        while(target>nums[end]){
            ans=bin_sear(nums,target,start,end*2);
            start=end+1;
            end*=2;
        }
        System.out.println(ans);
    }

    static int bin_sear(int[] arr, int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;

            }
            else if (arr[mid]>target) {
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}
