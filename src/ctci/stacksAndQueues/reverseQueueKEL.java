package ctci.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseQueueKEL {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < 11; i++) {
            q.offer(i);
        }
        int k = 5;
        reverseQueueK(q,k);
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
