package com.host.algorithm.dongtaiguihua;

import java.util.Arrays;

/**
 * created by xiaoyao01  on 2020/4/24.
 **/
public class Dynamic {
    public static void main(String[] args) {
        System.out.println(MaxChildArrayOrder(new int[]{3,1,4,1,5,9,2,6,5}));
    }
    /**
     * 数组最大递增子序列长度
     * {3，1，4，1，5，9，2，6，5} -> {1,4,5,9} 长度为4
     *
     * temp[i] = judge(temp[i-1]
     * @param a
     * @return
     */
    public static int MaxChildArrayOrder(int a[]){
        int temp[] = new int[a.length];
        Arrays.fill(temp,1);
        for(int i = 1; i < a.length; i++){
            for(int j = 0; j < i; j++){
                if (a[i] > a[j] && temp[j]+1 > temp[i]){
                    temp[i] = temp[j]+1;
                }
            }
        }
        int max = temp[0];
        //从temp数组里取出最大的值
        for(int i=1;i< a.length;i++){
            if(temp[i]>max){
                max = temp[i];
            }
        }
        return max;
    }
    public static int minNumberInRotateArray(int n[][]){
        int max = 0;
        int dp[][] = new int[n.length][n[0].length];
        for (int i = 1;i<n.length;i++){
            for (int j =0;j<n[i].length;j++){
                if (j==0){dp[i][j] = dp[i-1][j]+n[i][j];}
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+n[i][j];
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;

    }

    /**
     * 树的中序遍历 tree
     * deep(tree t){
     *      out->t
     *     if(l !=null)
     *     out->t.left()
     *
     * }
     */

}
