package ctci.stacksAndQueues;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

class MultiStack {
    /*
     * Approach:-
     * ->Fixed partition array
     * ->circular array for stacks => read from ctci
     * */
    private int numberOfStack = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public MultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStack];
        sizes = new int[numberOfStack];
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            throw new BufferOverflowException();
        }
        //Increment stack pointer and update the top of stack
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new BufferUnderflowException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new BufferUnderflowException();
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}

public class ThreeInOne {
    public static void main(String[] args) {
        testPushAndPop();
        testPeek();
        testIsEmpty();
        testIsFull();
        testBufferOverflowException();
        testBufferUnderflowException();
    }
    public static void testPushAndPop() {
        MultiStack multiStack = new MultiStack(3);

        multiStack.push(0, 1);
        multiStack.push(1, 2);
        multiStack.push(2, 3);

        int poppedValue1 = multiStack.pop(0);
        int poppedValue2 = multiStack.pop(1);
        int poppedValue3 = multiStack.pop(2);

        boolean isEmpty1 = multiStack.isEmpty(0);
        boolean isEmpty2 = multiStack.isEmpty(1);
        boolean isEmpty3 = multiStack.isEmpty(2);

        // Check if the values are as expected
        if (poppedValue1 == 1 && poppedValue2 == 2 && poppedValue3 == 3 &&
                isEmpty1 && isEmpty2 && isEmpty3) {
            System.out.println("testPushAndPop: PASSED");
        } else {
            System.out.println("testPushAndPop: FAILED");
        }
    }

    public static void testPeek() {
        MultiStack multiStack = new MultiStack(3);

        multiStack.push(0, 1);
        multiStack.push(1, 2);

        int peekedValue1 = multiStack.peek(0);
        int peekedValue2 = multiStack.peek(1);

        // Check if the values are as expected
        if (peekedValue1 == 1 && peekedValue2 == 2) {
            System.out.println("testPeek: PASSED");
        } else {
            System.out.println("testPeek: FAILED");
        }
    }

    public static void testIsEmpty() {
        MultiStack multiStack = new MultiStack(3);

        boolean isEmpty1 = multiStack.isEmpty(0);
        boolean isEmpty2 = multiStack.isEmpty(1);
        boolean isEmpty3 = multiStack.isEmpty(2);

        // Check if all stacks are initially empty
        if (isEmpty1 && isEmpty2 && isEmpty3) {
            System.out.println("testIsEmpty: PASSED");
        } else {
            System.out.println("testIsEmpty: FAILED");
        }
    }

    public static void testIsFull() {
        MultiStack multiStack = new MultiStack(3);

        boolean isFull1 = multiStack.isFull(0);
        boolean isFull2 = multiStack.isFull(1);
        boolean isFull3 = multiStack.isFull(2);

        // Check if all stacks are initially not full
        if (!isFull1 && !isFull2 && !isFull3) {
            System.out.println("testIsFull: PASSED");
        } else {
            System.out.println("testIsFull: FAILED");
        }
    }

    public static void testBufferOverflowException() {
        MultiStack multiStack = new MultiStack(3);

        multiStack.push(0, 1);
        multiStack.push(0, 2);
        multiStack.push(0, 3);

        try {
            multiStack.push(0, 4);
            System.out.println("testBufferOverflowException: FAILED");
        } catch (BufferOverflowException e) {
            System.out.println("testBufferOverflowException: PASSED");
        }
    }

    public static void testBufferUnderflowException() {
        MultiStack multiStack = new MultiStack(3);

        try {
            multiStack.pop(0);
            System.out.println("testBufferUnderflowException: FAILED");
        } catch (BufferUnderflowException e) {
            System.out.println("testBufferUnderflowException: PASSED");
        }
    }


}
