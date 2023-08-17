package ctci.stacksAndQueues;

import java.util.EmptyStackException;

class MyStack<T> {
    private static int size = 0;

    private static class StackNode<T> {
        private T val;
        private StackNode<T> next;

        public StackNode() {
        }

        ;

        public StackNode(T item) {
            this.val = item;
            this.next = null;
        }
    }

    private StackNode<T> top;

    public boolean push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
        size++;
        return true;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.val;
        top = top.next;
        size--;
        return item;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}

class DynamicStack<T> {
    private T[] arr;
    private int size;
    private static final int DEFAULT_VALUE = 10;

    public DynamicStack() {
        //noinspection unchecked
        arr = (T[]) new Object[DEFAULT_VALUE];
        size = 0;
    }

    public boolean push(T item) {
        if (size == arr.length) {
            resizeArray(arr.length * 2);
        }
        arr[size++] = item;
//        size++;
        return true;
    }

    public T pop() {
        if (size == 0) throw new EmptyStackException();
        T item = arr[size - 1];
        arr[size - 1] = null;
        size--;

        if (size > 0 && size < arr.length / 4) {
            resizeArray(arr.length / 2);
        }
        return item;
    }

    public T peek(){
        return arr[size-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void resizeArray(int newSize){
        //noinspection unchecked
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }
}

public class Stack {
    public static void main(String[] args) {
        DynamicStack<Integer> dummy = new DynamicStack<>();
        dummy.push(10);
        dummy.push(19);
        dummy.push(2);
        dummy.push(20);
        System.out.println(dummy.size());
        System.out.println(dummy.peek());
        System.out.println(dummy.pop());
        System.out.println(dummy.pop());
        System.out.println(dummy.pop());
        System.out.println(dummy.pop());
    }
}
