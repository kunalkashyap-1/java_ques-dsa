package ctci.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val ) {
        this.val = val;
    }

    public ArrayList<Integer> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int qlen = queue.size();
            ArrayList<Integer> ElLevel = new ArrayList<>();
            for (int i = 0; i < qlen; i++) {
                Node node = queue.poll();
                if (node != null) {
                    ElLevel.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            res.addAll(ElLevel);
        }
        return res;
    }
}

public class minimalBST {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node res = createMinimalBST(arr,0,arr.length-1);
        System.out.println(res.levelOrder(res));
    }

    static Node createMinimalBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node n = new Node(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
}
