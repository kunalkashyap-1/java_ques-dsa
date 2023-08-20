package ctci.stacksAndQueues;

import java.nio.BufferUnderflowException;

class stackWithMin extends MyStack<Integer>{
    private MyStack<Integer> min ;

    public stackWithMin(){
        min = new MyStack<Integer>();
    }

    @Override
    public boolean push(Integer item) {
        if (item <= min()) {
            min.push(item);
        }
        return super.push(item);
    }

    @Override
    public Integer pop() {
        int value = super.pop();
        if(value == min()) min.pop();
        return value;
    }

    public int min(){
        if(min.isEmpty()) return Integer.MAX_VALUE;
        return min.peek();
    }
}

public class stack_min {
    public static void main(String[] args) {
        stackWithMin st = new stackWithMin();
        st.push(12);
        st.push(6);
        st.push(11);
        st.push(2);
        st.push(1);
        while(!st.isEmpty()){
            System.out.println(st.min());
            System.out.println(st.pop());
        }
    }
}
