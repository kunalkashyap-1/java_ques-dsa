public class rotated_binary_search {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(nums,target));
    }

    static int pivot_el(int[] nums){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[mid]<=nums[start]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return -1;
    }

    static int search(int[] nums, int target){
        int pivot = pivot_el(nums);
        //if not found pivot-> the array is not rotated so,do normal binary search
        if(pivot==-1){
            return bin_sear(nums,target,0,nums.length-1);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        if(target>=nums[0]){
            return bin_sear(nums,target,0,pivot-1);
        }
        return bin_sear(nums,target,pivot+1,nums.length-1);
    }

    static int bin_sear(int[] arr,int target,int start,int end){
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
