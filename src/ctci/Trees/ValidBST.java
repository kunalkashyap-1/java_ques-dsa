package ctci.Trees;

public class ValidBST {
    public static void main(String[] args) {
        Integer[] arr = {4, 2, 6, 1, 3, 5, 7};
        TreeNode node = ArrToTree(arr, 0);
        System.out.println(valid(node));
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

    //brute force => store inorder in an array and check if it is sorted or not, but it might fail in some cases 

    static Integer last_Printed = null;

    static boolean valid(TreeNode root) {
        if (root == null) return true;

        //check left
        if (!valid(root.left)) return false;

        //check current
        if (last_Printed != null && root.val <= last_Printed) {
            return false;
        }
        last_Printed = root.val;

        //check right
        if (!valid(root.right)) return false;

        return true;
    }
}
