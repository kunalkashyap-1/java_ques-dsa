package DSA_sheet.arrays;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(find(arr));
    }

    static int find(int[] arr){
        int n = arr.length;
        if(arr[0] == 0) return -1;
        if(n<=1)return 0;

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for(int i =1; i<n; i++){
            if(i == n-1) return jumps;

            maxReach= Math.max(maxReach, i+arr[i]);
            steps--;

            if(steps == 0){
                jumps++;
                if(i >= maxReach){
                    return -1;
                }
                steps = maxReach -i;
            }
        }
        return -1;
    }
}
