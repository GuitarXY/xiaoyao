package com.host.algorithm.dongtaiguihua;

/**
 * Created by xiaoy on 2019/11/29
 * 该人从{0，0}走到{n，m}
 * 每一步只可以往下走或者往右走，且相对应的每一步都会有一定数量的花生
 * 求走到{n，m}摘得花生的最大值
 *
 *
 * 变式：求摘花生最少的
 */
public class 摘花生 {
    private int[][] hs = {{1,3,4},
                          {2,3,4},
                          {3,4,5}
                        }; //最优解应该是1，3，4，4，5
    private int[][] re = new int[hs.length][hs[0].length];//存储每一步的最优结果


    public void solve(){
        for (int i = 0; i < hs.length; i++ )
            for (int j = 0; j < hs[0].length; j++){
                //这里只要求上一步的最优解+这一步的花生数量
                //注意如果为0时会有下标越界，要做处理
                re[i][j] = Math.max(i==0 ? 0 : re[i-1][j], j == 0 ? 0 : re[i][j-1]) + hs[i][j];
            }
        System.out.println(re[hs.length-1][hs[0].length-1]);
    }
    public static void main(String[] args){
        摘花生 s = new 摘花生();
        s.solve();
    }
}
