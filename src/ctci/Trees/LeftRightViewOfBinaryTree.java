package ctci.Trees;

import java.util.ArrayList;

public class LeftRightViewOfBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {4,3,5,2,1,null,null,null,null,6,7};
        TreeNode root= new TreeNode().ArrToTree(arr,0);
        ArrayList<Integer> list = new ArrayList<>();
        printView(root,list,0);
        System.out.println(list);
    }

    static void printView(TreeNode root, ArrayList<Integer> list, int level){
        if(root == null) return;
        if(level >= list.size()){
            list.add(root.val);
        }
        //for left view
//        printView(root.left,list,level+1);
//        printView(root.right,list,level+1);
        //for right view
        printView(root.right,list,level+1);
        printView(root.left,list,level+1);
    }
}
