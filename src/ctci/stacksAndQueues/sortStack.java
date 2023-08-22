package ctci.stacksAndQueues;

public class sortStack {
    public static void main(String[] args) {
        SimpleStack stack = new SimpleStack(5);
        stack.push(12);
        stack.push(1);
        stack.push(2);
        stack.push(14);
        stack.push(21);
        sort(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    static void sort(SimpleStack stack) {
        SimpleStack temp = new SimpleStack(5);
        temp.push((int) stack.pop());
        while (!stack.isEmpty()) {
            int t = stack.pop();
            while (!temp.isEmpty() && temp.peek() > t) {
                stack.push(temp.pop());
            }
            temp.push(t);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}
