package ctci.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepth {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, null, null, 9};
        TreeNode node = ArrToTree(arr, 0);
        ArrayList<LinkedList<Integer>> result = DepthListBFS(node);
        ArrayList<LinkedList<Integer>> res = DepthListDFS(node);

        // Print the result
        for (LinkedList<Integer> list : result) {
            System.out.println(list);
        }
        for (LinkedList<Integer> list : res) {
            System.out.println(list);
        }
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

    static ArrayList<LinkedList<Integer>> DepthListBFS(TreeNode root) {
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int qlen = q.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < qlen; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    levelList.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            res.add(levelList);
        }
        return res;
    }

    static ArrayList<LinkedList<Integer>> DepthListDFS(TreeNode root) {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        createLevelList(root, lists, 0);
        return lists;
    }

    static void createLevelList(TreeNode root, ArrayList<LinkedList<Integer>> lists, int level) {
        if (root == null) return;

        LinkedList<Integer> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root.val);
        createLevelList(root.left, lists, level + 1);
        createLevelList(root.right, lists, level + 1);
    }
}
