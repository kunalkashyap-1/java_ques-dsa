import java.util.Stack;
import java.util.Scanner;

public class binary_format {
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        method_1(n,st);
        while(!st.isEmpty()){
            System.out.print(st.pop());
        }
    }
    static void method_1(int n,Stack<Integer> st){
        while(n>0){
            int mask=1;
            int curr=mask&n;
            st.push(curr);
            n>>=1;
        }
    }
}
