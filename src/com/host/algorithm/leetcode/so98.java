package com.host.algorithm.leetcode;
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class so98 {
    /**
     * 验证二叉搜索树
     * 左子树节点必须小于右子树
     */
    public static boolean isValidBST(TreeNode root) {
        while(root.left!=null){
            if (root.left.val <= root.val )return isValidBST(root.left);
            else return false;
        }
        while(root.right!=null){
            if (root.right.val >= root.val )return isValidBST(root.right);
            else return false;
        }
        return isValidBST(root.left)&&isValidBST(root.right);

    }
    public static void main(String[] args){
        TreeNode t = new TreeNode(6);
        TreeNode t1 = new TreeNode(8);
        TreeNode t2= new TreeNode(1);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(9);
        t3.right = t2;
        t4.left = t1;
        t.left = t3;
        t.right = t4;
        System.out.println(isValidBST(t));
    }
}
