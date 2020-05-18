package com.util;

import java.util.ArrayList;

/**
 * created by xiaoyao01  on 2020/4/24.
 **/


public class TreeUtil {
    //层级遍历树
    public static  ArrayList<ArrayList<Integer>> Print(TreeNode treeNode){
        ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
        if(treeNode==null)
        {
            return out;
        }
        ArrayList<TreeNode> queue=new ArrayList<TreeNode>();
        ArrayList<Integer> in=new ArrayList<Integer>();
        queue.add(treeNode);
        int start =0,end =0;
        while (!queue.isEmpty()){

            TreeNode remove = queue.remove(0);
            in.add(remove.val);
            start++;
            if(remove.left!=null)
                queue.add(remove.left);
            if(remove.right!=null)
                queue.add(remove.right);
            if(start == end){
                end = queue.size();
                start =0;
                out.add(in);
                in.clear();
            }

        }
        return out;
    }

    /**
     *
     */
    private static ArrayList con=new ArrayList();
    public static ArrayList firstConsole(TreeNode treeNode) {
        if (treeNode!= null){con.add(treeNode.val);}
        if (treeNode.left!=null){firstConsole(treeNode.left);}
        if (treeNode.right!=null){firstConsole(treeNode.right);}
        return con;
    }

    public static void main(String[] args) {

    }
}
