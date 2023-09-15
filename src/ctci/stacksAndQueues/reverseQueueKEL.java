package ctci.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseQueueKEL {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        q.offer(7);
        q.offer(8);
        reverseQueueK(q,5);
        System.out.println(q);
    }
    static void reverseQueueK(Queue<Integer> q,int k){
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<k;i++){
            s.push(q.poll());
        }
        while(!s.isEmpty()) {
            q.offer(s.pop());
        }
        for (int i = 0; i < q.size() - k; i++) {
            q.offer(q.poll());
        }
    }
}
