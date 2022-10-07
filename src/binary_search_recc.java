public class binary_search_recc {
    public static void main(String[] args) {
        int[] arr={7,9,12,23,43,54,65,87,89};
        System.out.println(recc_binary(arr,59,0,arr.length-1));
    }

    static boolean recc_binary(int[] arr,int target,int start, int end){
        int mid=start+(end-start)/2;
        if (start > end) {
            return false;
        }
        if(target==arr[mid]){
            return true;
        }
        else if(arr[mid]>target){
            return (recc_binary(arr,target,start,mid-1));
        }
        else {
            return (recc_binary(arr,target,mid+1,end));
        }
    }
}
