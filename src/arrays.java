import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {
        //syntax:  datatype[] variable_name = new datatype[size]
        int[] arr;//declaration of array
        arr=new int[]{0,1,2,3,4}; //here object is created in the heap memory OR initialization
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));

    }
}
