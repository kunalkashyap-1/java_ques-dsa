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

    private int size = 0; // Removed 'static' modifier
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
    private int size, front = -1, rear = -1; // Removed 'static' modifier
    private static final int DEFAULT_SIZE = 10;

    public MyArrQueue() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    public MyArrQueue(T data) {
        arr = (T[]) new Object[DEFAULT_SIZE];
        front = rear = 0;
        arr[rear] = data;
        size = 1;
    }

    public boolean enqueue(T data) {
        if (size == arr.length) {
            resizeArray(arr.length * 2);
        }
        if (front == -1 && rear == -1) {
            front = rear = 0;
        }
        arr[rear] = data;
        rear = (rear + 1) % arr.length; // Update rear correctly
        size++;
        return true;
    }

    public T dequeue() {
        if (front == rear) throw new NoSuchElementException();
        T data = arr[front];
        arr[front++] = null;
        size--;
        if (size > 0 && size <= arr.length / 4) { // Adjust condition
            resizeArray(arr.length / 2);
        }
        return data;
    }

    public T peek() {
        if (front == -1) throw new NoSuchElementException();
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resizeArray(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(arr, 0, temp, 0, size);
        arr = temp;
    }
}

class MyCircularQueue<T> {
    private int size; // Removed 'static' modifier

    private class CircularNode<T> {
        T data;
        CircularNode next;

        public CircularNode(T data) {
            this.data = data;
        }
    }

    private CircularNode<T> front;
    private CircularNode<T> rear;

    public boolean enqueue(T data) {
        CircularNode<T> t = new CircularNode<>(data);
        if (front == null && rear == null) {
            front = rear = t;
            rear.next = front;
        } else {
            rear.next = t;
            rear = t;
            rear.next = front;
        }
        size++;
        return true;
    }

    public T dequeue() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        T data = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
        size--;
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

class MyCircularArrQueue<T> {
    private static final int DEFAULT_SIZE = 10;
    private T[] arr;
    private int size, front = -1, rear = -1;

    public MyCircularArrQueue() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    public MyCircularArrQueue(T data) {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
        front = rear = 0;
        arr[rear] = data;
    }

    public boolean enqueue(T data) {
        if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[rear] = data;
        } else if ((rear + 1) % arr.length == front) {
            throw new BufferOverflowException();
        } else {
            rear = (rear + 1) % arr.length;
            arr[rear] = data;
        }
        size++;
        return true;
    }

    public T dequeue() {
        T data = null;
        if (front == -1 && rear == -1) {
            throw new BufferUnderflowException();
        } else if (front == rear) {
            data = arr[front];
            front = rear = -1;
            size--;
            return data;
        } else {
            data = arr[front];
            arr[front] = null;
            front = (front + 1) % arr.length;
            size--;
            return data;
        }
    }

    public T peek() {
        if (front == -1) throw new NoSuchElementException();
        return arr[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int size() {
        return size;
    }
}

class MyDeque<T> {
    private class DequeNode<T> {
        private T data;
        private DequeNode<T> prev;
        private DequeNode<T> next;

        public DequeNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private DequeNode<T> front;
    private DequeNode<T> rear;

    public boolean isEmpty() {
        return front == null;
    }

    public boolean addToFront(T data) {
        DequeNode<T> temp = new DequeNode<>(data);
        if (isEmpty()) {
            front = rear = temp;
        } else {
            temp.next = front;
            front.prev = temp;
            front = temp;
        }
        return true;
    }

    public boolean addToRear(T data) {
        DequeNode<T> temp = new DequeNode<>(data);
        if (isEmpty()) {
            front = rear = temp;
        } else {
            temp.prev = rear;
            rear.next = temp;
            rear = temp;
        }
        return true;
    }

    public T removeFromFront() {
        if (isEmpty()) throw new NoSuchElementException();
        T data = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        return data;
    }

    public T removeFromRear() {
        if (isEmpty()) throw new NoSuchElementException();
        T data = rear.data;
        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        return data;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public T peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return rear.data;
    }
}

public class Queue {
    public static void main(String[] args) {
        testMyQueue();
        testMyArrQueue();
        testMyCircularQueue();
        testMyCircularArrQueue();
        testMyDeque();
    }

    public static void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("MyQueue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    public static void testMyArrQueue() {
        MyArrQueue<String> arrQueue = new MyArrQueue<>();
        arrQueue.enqueue("A");
        arrQueue.enqueue("B");
        arrQueue.enqueue("C");

        System.out.println("\nMyArrQueue:");
        while (!arrQueue.isEmpty()) {
            System.out.println(arrQueue.dequeue());
        }
    }

    public static void testMyCircularQueue() {
        MyCircularQueue<Character> circularQueue = new MyCircularQueue<>();
        circularQueue.enqueue('X');
        circularQueue.enqueue('Y');
        circularQueue.enqueue('Z');

        System.out.println("\nMyCircularQueue:");
        while (!circularQueue.isEmpty()) {
            System.out.println(circularQueue.dequeue());
        }
    }

    public static void testMyCircularArrQueue() {
        MyCircularArrQueue<Double> circularArrQueue = new MyCircularArrQueue<>();
        circularArrQueue.enqueue(1.1);
        circularArrQueue.enqueue(2.2);
        circularArrQueue.enqueue(3.3);

        System.out.println("\nMyCircularArrQueue:");
        while (!circularArrQueue.isEmpty()) {
            System.out.println(circularArrQueue.dequeue());
        }
    }

    public static void testMyDeque() {
        MyDeque<String> deque = new MyDeque<>();
        deque.addToFront("Front1");
        deque.addToRear("Rear1");
        deque.addToFront("Front2");
        deque.addToRear("Rear2");

        System.out.println("\nMyDeque:");
        System.out.println(deque.peekFront());
        System.out.println(deque.peekRear());

        while (!deque.isEmpty()) {
            System.out.println(deque.removeFromFront());
        }
    }
}
