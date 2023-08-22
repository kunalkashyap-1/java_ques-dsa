package ctci.stacksAndQueues;

public class StackToQueue {
    private DynamicStack<Integer> Snew, Sold;

    public StackToQueue(){
        Snew = new DynamicStack<>();
        Sold = new DynamicStack<>();
    }

    public int size(){
        return Snew.size() + Sold.size();
    }
    public void enqueue(int v){
        Snew.push(v);
    }
    public int dequeue(){
        shiftStack();
        return Sold.pop();
    }
    public int peek(){
        shiftStack();
        return Sold.peek();
    }
    private void shiftStack(){
        if(Sold.isEmpty()){
            while(!Snew.isEmpty()){
                Sold.push(Snew.pop());
            }
        }
    }

    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        queue.enqueue(12);
        queue.enqueue(9);
        queue.enqueue(7);
        queue.enqueue(13);
        queue.enqueue(1);
        while(queue.size() != 0){
            System.out.println(queue.dequeue());
        }
    }
}
