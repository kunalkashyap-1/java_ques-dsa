package ctci.stacksAndQueues;

import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.EmptyStackException;

class SimpleStack {
    private int[] arr;
    private int size;
    private int capacity;

    public SimpleStack(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void push(int val) {
        if (size == capacity) {
            throw new BufferOverflowException();
        }
        arr[size++] = val;
    }

    public int pop() {
        if (size == 0) throw new EmptyStackException();
        int temp = arr[size - 1];
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int peek(){
        return arr[size-1];
    }

    public int size() {
        return size;
    }
}

public class StackOfPlates {
    ArrayList<SimpleStack> stacks = new ArrayList<>();
    private int capacity;

    public StackOfPlates(int capacity){
        this.capacity = capacity;
        SimpleStack stack = new SimpleStack(capacity);
    }
    public SimpleStack getLastStack() {
        if (stacks.isEmpty()) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int val) {
        SimpleStack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(val);
        } else {
            SimpleStack stack = new SimpleStack(capacity);
            stack.push(val);
            stacks.add(stack);
        }
    }

    public int pop() {
        SimpleStack last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int temp = last.pop();
        if (last.isEmpty()) stacks.remove(stacks.size() - 1);
        return temp;
    }

    public boolean isEmpty() {
        SimpleStack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public static void main(String[] args) {
        StackOfPlates stack = new StackOfPlates(2);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(7);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
