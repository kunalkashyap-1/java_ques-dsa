package ctci.Trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class CheckBalanced {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, null, null, 9};
        TreeNode node = ArrToTree(arr, 0);
        System.out.println(isBalanced(node));
        System.out.println(balanced(node));
    }

    // Helper method to convert an array to a binary tree
    static TreeNode ArrToTree(Integer[] arr, int index) {
        TreeNode root = null;
        if (index < arr.length) {
            Integer value = arr[index];
            if (value != null) {
                root = new TreeNode(value);
                root.left = ArrToTree(arr, 2 * index + 1);
                root.right = ArrToTree(arr, 2 * index + 2);
            }
        }
        return root;
    }

    static int getHeight(TreeNode root){
        if(root == null){return -1;}
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    static boolean isBalanced(TreeNode root){
        if(root == null) return true;
        int diff = Math.abs(getHeight(root.left)-getHeight(root.right));
        if(diff >1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    static int checkHeight(TreeNode node){
        if(node == null) return -1;
        int leftHeight = checkHeight(node.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(node.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(Math.abs(leftHeight - rightHeight) >1) {
            return Integer.MIN_VALUE;
        }
        else{
            return Math.max(leftHeight, rightHeight) +1;
        }
    }

    static boolean balanced(TreeNode root){
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}
