public class split_array_largest_sum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,9};
        int m = 2;
        System.out.println(splitArray(nums,m));
    }

    static int splitArray(int[] nums,int m){
        int start=0;
        int end=0;
        for (int j : nums) {
            start = Math.max(start, j);
            end += j;
        }
        while(start<end){
            //try for the middle as the potential ans
            int mid = start+(end-start)/2;
            int sum=0;
            int pieces=1;
            for(int num:nums){
                if(sum+num>mid){
                    //you can't add in this subarray make new one
                    sum=num;
                    pieces++;
                }
                else{
                    sum+=num;
                }
            }
            if(pieces>m){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return end;
    }
}
