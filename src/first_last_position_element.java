public class first_last_position_element {
    public static void main(String[] args){
    int[] nums={5,7,7,8,8,8,10};
    int target=8;
    for (int el : pos_search(nums,target)){
        System.out.print(el+" ");
    }
    }


    static int[] pos_search(int[] nums,int target){
        int[] arr={-1,-1};
        arr[0]=bin_sear(nums,target,true);
        arr[1]=bin_sear(nums,target,false);
        return arr;
    }


    static int bin_sear(int[] nums, int target, boolean pos){
        int ans=-1;
        int first=0;
        int last=nums.length-1;
        while(first<=last){
            int mid=first+(last-first)/2;
            if(nums[mid]==target){
                if(pos){
                    ans=mid;
                    last=mid-1;
                }
                else{
                    ans=mid;
                    first=mid+1;
                }
            }
            else if (nums[mid]>target) {
                last=mid-1;
            }
            else{
                first=mid+1;
            }
        }
        return ans;
    }
}
