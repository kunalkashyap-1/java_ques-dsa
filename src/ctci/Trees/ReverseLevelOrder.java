package ctci.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
    public static void main(String[] args) {
        Integer[] arr = {10,20,30,40,60};
        TreeNode root = new TreeNode().ArrToTree(arr,0);
        System.out.println(reverseLevelOrder(root));
    }

    static ArrayList<Integer> reverseLevelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i<n ; i++) {
                TreeNode temp = q.poll();
                if(temp != null) {
                    stack.push(temp.val);
                    if (temp.right != null) q.offer(temp.right);
                    if (temp.left != null) q.offer(temp.left);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
