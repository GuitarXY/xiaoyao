package com.host.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoy on 2019/12/23
 */
public class 二叉树广度优先遍历 {
    public static void main(String[] args){
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
        ArrayList<ArrayList<Integer>> list = findNFS(treeNode);
        System.out.println(list);
    }

    /**
     * 用队列实现广度优先遍历
     * @param root
     * @return
     */
    private static ArrayList<ArrayList<Integer>> findNFS(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        //层序遍历需要用到队列
        Queue<TreeNode> queue=new LinkedList<>();
        //推荐用offer代替add
        queue.offer(root);
        while(!queue.isEmpty()) {
            //用size控制循环次数
            int size=queue.size();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            res.add(list);
        }
        return res;

    }
}
