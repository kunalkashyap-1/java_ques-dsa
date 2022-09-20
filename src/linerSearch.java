import java.util.Scanner;

public class linerSearch {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the array");
        int[] arr=new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=input.nextInt();
        }
        System.out.println("Enter target to be searched");
        int target = input.nextInt();

        System.out.println(linear_Search(arr,target));
    }

    static boolean linear_Search(int[] arr,int target){
        for(int el:arr){
            if(el==target) {
                return true;
            }
        }
        return false;
    }

}
