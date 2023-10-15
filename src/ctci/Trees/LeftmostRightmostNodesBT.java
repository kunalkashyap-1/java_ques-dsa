package ctci.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeftmostRightmostNodesBT {
    public static void main(String[] args) {
        Integer[] arr = {15,10,20,8,12,16,25};
        TreeNode root = new TreeNode().ArrToTree(arr,0);
        System.out.println(printLeftRight(root));
    }
    static ArrayList<Integer> printLeftRight(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i< n; i++){
                TreeNode temp = queue.poll();
                if(temp != null) {
                    if (i == 0 || i == n - 1) {
                        list.add(temp.val);
                    }
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }
            }
        }
        return list;
    }
}
