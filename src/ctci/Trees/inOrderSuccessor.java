package ctci.Trees;

public class inOrderSuccessor {
    public static void main(String[] args) {
        Integer[] arr = {4, 2, 6, 1, 3, 5, 7};
        TreeNode node = ArrToTree(arr, 0);
        System.out.println(successor(node, 3));
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

    static Integer successor(TreeNode root, int target) {
        Integer res = null;
        while (root != null) {
            if (root.val <= target) {
                root = root.right;
            } else {
                res = root.val;
                root = root.left;
            }
        }
        return res;
    }
}
