package ctci.stacksAndQueues;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.NoSuchElementException;

class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private static int size = 0;
    private QueueNode<T> front;
    private QueueNode<T> rear;

    public boolean add(T data) {
        QueueNode<T> t = new QueueNode<>(data);
        if (rear != null) {
            rear.next = t;
        }
        rear = t;
        size++;
        if (front == null) {
            front = rear;
        }
        return true;
    }

    public T remove() {
        if (front == null) throw new NoSuchElementException();
        T data = front.data;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public T peek() {
        if (front == null) throw new NoSuchElementException();
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}

class MyArrQueue<T> {
    private T[] arr;
    private static int size, front =-1, rear=-1;
    private static final int DEFAULT_SIZE = 10;

    public MyArrQueue(){
        arr = (T[]) new Object[DEFAULT_SIZE];
        size =0;
    }
    public MyArrQueue(T data){
        arr = (T[]) new Object[DEFAULT_SIZE];
        front = rear = 0;
        arr[rear] = data;
        size =1;
    }

    public boolean enqueue(T data){
        if(size == arr.length){
            resizeArray(arr.length*2);
        }
        if(front == -1 && rear == -1){
            front = rear = 0;
        }
        arr[rear] = data;
        rear++;
        return true;
    }

    public T dequeue(){
        if(front == rear) throw new NoSuchElementException();
        T data = arr[front];
        arr[front++] = null;
        size--;
        if(size >0 && size < arr.length/4){
            resizeArray(arr.length/2);
        }
        return data;
    }

    public T peek(){
        if(front == -1)throw new NoSuchElementException();
        return arr[front];
    }
    public boolean isEmpty(){
        return front == -1;
    }
    public int size(){
        return size;
    }
    public void resizeArray(int newSize){
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(arr,0,temp,0,size);
        arr = temp;
    }
}

class MyCircularQueue<T>{
    private static int size;
    private class circularNode<T>{
        T data;
        circularNode next;

        public circularNode(){};
        public circularNode(T data){
            this.data = data;
        }
    }

    private circularNode<T> front;
    private circularNode<T> rear;

    public boolean enqueue(T data){
        circularNode<T> t = new circularNode<>(data);
        if(front == null && rear == null){
            front = rear = t;
            rear.next = front;
        }else{
            rear.next = t;
            rear =t;
            rear.next = front;
        }
        size++;
        return true;
    }

    public T dequeue(){
        T data = front.data;
        if(front == null){
            throw new NoSuchElementException();
        } else if (front == rear) {
            front = rear = null;
        }else{
            front = front.next;
            rear.next = front;
        }
        size--;
        return data;
    }

    public T peek(){
        if(front == null) throw new NoSuchElementException();
        return front.data;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public int size(){
        return size;
    }
}

class MyCircularArrQueue<T> {
    private static final int DEFAULT_SIZE = 10;
    private T[] arr;
    private int size, front = -1, rear =-1;

    public MyCircularArrQueue(){
        arr = (T[]) new Object[DEFAULT_SIZE];
        size =0;
    }

    public MyCircularArrQueue(T data){
        arr = (T[]) new Object[DEFAULT_SIZE];
        size=0;
        front = rear= 0;
        arr[rear] = data;
    }

    public boolean enqueue(T data){
        if(front == -1 && rear == -1){
            front = rear = 0;
            arr[rear] = data;
        }else if((rear+1)% arr.length == front){
            throw new BufferOverflowException();
        }else{
            rear = (rear+1)% arr.length;
            arr[rear] = data;
        }
        size++;
        return true;
    }

    public T dequeue(){
        if(front == -1 && rear == -1){
            throw new BufferUnderflowException();
        } else if (front == rear) {
            front = rear = -1;
            size--;
        }else{
            T data = arr[front];
            arr[front] = null;
            front = (front+1)%arr.length;
            size--;
            return data;
        }
        return null;
    }

    public T peek(){
        if(front == -1)throw new NoSuchElementException();
        return arr[front];
    }
    public boolean isEmpty(){
        return front == -1;
    }
    public int size(){
        return size;
    }
}
//class MyPriorityQueue {
//    //DO THIS LATER
//}

class MyDeque<T>{
    private T[] arr;

    public MyDeque(int size){
        arr = (T[]) new Object[size];
    }

    public MyDeque(T data, int size){};

}

public class Queue {
    public static void main(String[] args) {

    }
}
