package ctci.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
        return this.height - 1;
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
        System.out.print("->" + node.val);
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
        System.out.print("->" + node.val);
        PreOrder(node.left);
        PreOrder(node.right);
    }

    public void PostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print("->" + node.val);
    }

    public ArrayList<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int qlen = queue.size();
            ArrayList<Integer> ElLevel = new ArrayList<>();
            for (int i = 0; i < qlen; i++) {
                TreeNode node = queue.poll();
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

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        if (lheight > rheight) {
            return (lheight + 1);
        } else {
            return (rheight + 1);
        }
    }

    public void printLevelOrder(TreeNode root) {
        int h = height(root);
        for (int i = 0; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    public void printCurrentLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) System.out.print("-> " + root.val);
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public void InOrderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print("-> " + curr.val);
            curr = curr.right;
        }
    }

    public void PreOrderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            System.out.print("-> " + curr.val);

            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
        }

    }

    public void PostOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            // Check for empty stack
            if (stack.empty()) return;
            root = stack.pop();

            if (!stack.empty() && stack.peek() == root) root = root.right;

            else {
                System.out.print(root.val + " ");
                root = null;
            }
        }

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
        tree.PostOrderIterative(tree);
    }
}
