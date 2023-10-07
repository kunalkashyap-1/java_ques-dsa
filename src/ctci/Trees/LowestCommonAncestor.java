package ctci.Trees;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        int p = 5;
        int q = 1;
        TreeNode tree = new TreeNode().ArrToTree(arr,0);
        System.out.println(ancestor(tree,p,q).val);
    }

    static TreeNode ancestor(TreeNode root, int p, int q){
        if (root == null) return null;

        // If either p or q is found, return that node as a potential ancestor.
        if (root.val == p || root.val == q) return root;

        // Recursively search for p and q in the left and right subtrees.
        TreeNode left = ancestor(root.left, p, q);
        TreeNode right = ancestor(root.right, p, q);

        // If both p and q are found in the left and right subtrees, then root is the LCA.
        if (left != null && right != null) return root;

        // If one of them is found (either in left or right subtree), return that node.
        return left != null ? left : right;
    }
}
