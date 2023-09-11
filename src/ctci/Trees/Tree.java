package ctci.Trees;

import java.util.ArrayList;

class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    //    private TreeNode root;
    private int height = 0;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
        this.height++;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.height++;
    }

    public void insert(TreeNode root, int val) {
    }

    public int getHeight() {
        return this.height -1;
    }

    ;

    public TreeNode ArrToTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) return null;
        TreeNode node = new TreeNode(arr[index]);
        node.left = ArrToTree(arr, (2 * index) + 1);
        node.right = ArrToTree(arr, (2 * index) + 2);
        node.height = 1 + Math.max((node.left != null ? node.left.height : 0), (node.right != null ? node.right.height : 0));
        return node;
    }

    public void InOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        InOrder(node.left);
        System.out.print("->" + node.val );
        InOrder(node.right);
    }

    public ArrayList<Integer> InOrderList(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node != null) {
            list.addAll(InOrderList(node.left));
            list.add(node.val);
            list.addAll(InOrderList(node.right));
        }
        return list;
    }
    public void PreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print("->" + node.val );
        PreOrder(node.left);
        PreOrder(node.right);
    }
    public void PostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print("->" + node.val );
    }
}

public class Tree {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, null, null, 9};
        TreeNode tree = new TreeNode().ArrToTree(arr, 0);
//        System.out.println(tree.getHeight());
//        System.out.println("InOrder:-");
//        tree.InOrder(tree);
//        System.out.println();
//        System.out.println("PreOrder:-");
//        tree.PreOrder(tree);
//        System.out.println();
//        System.out.println("PostOrder:-");
//        tree.PostOrder(tree);
        System.out.println(tree.InOrderList(tree));
    }
}
