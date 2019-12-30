package com.host.algorithm;

import java.util.ArrayList;

/**
 * Created by xiaoy on 2019/12/23
 */
public class 二叉树深度优先搜索 {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(8);
        /**
         *              1
         *          2        5
         *        3   4   6     7
         *                 8
         * */
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;
        treeNode5.right = treeNode7;
        treeNode.left = treeNode1;
        treeNode.right = treeNode4;
        ArrayList<Integer> list = findDFS(treeNode);
        System.out.println(list);
    }

    /**
     * 深度优先搜索二叉树
     * @param treeNode1
     * @return
     */
    private static ArrayList<Integer> findDFS(TreeNode treeNode1) {
        ArrayList<Integer> list = new ArrayList<>();
        DFS(list,treeNode1);
        return list;


    }

    private static void DFS(ArrayList<Integer> list, TreeNode treeNode1) {
        if (treeNode1.left != null)
            DFS(list,treeNode1.left);
        list.add(treeNode1.val);

        if (treeNode1.right != null)
            DFS(list,treeNode1.right);

        return;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
