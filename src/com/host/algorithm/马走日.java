package com.host.algorithm;

/**
 * Created by xiaoy on 2019/11/26
 * 给定一副棋盘，马从{0，0}开始走，问多少步能走完整个棋盘
 *
 * 递归深度优先的思想
 */
public class 马走日 {
    //8*8的国际象棋棋盘
    public int[][] qipan = new int[8][8];
    public static int index;//马走到第几步
    //马能走的方向
    public int[] dx = {-2,-1,-1,-2,2,1,1,2};
    public int[] dy = {1,2,-2,-1,-1,-2,2,-1};


    /**
     *
     * @param temp 马儿现在的位置
     */
    public void move (int[] temp){
        int[] next = new int[2];
        if (temp[0] < 0 || temp[1] < 0 || temp[0] >= qipan[0].length || temp[1] >= qipan.length){
            return;
        }
        if (qipan[temp[0]][temp[1]] != 0){ // 如果这条路被走过，也返回
            return;
        }

        qipan[temp[0]][temp[1]] = index;//代表第八步可以走
        index ++ ;

        if (index > qipan[0].length * qipan.length){
            output();
            //这里可以把最优值保存起来，去找最短的
            return;
        }else {
            //列举出马儿下一步可能走的所有点，都试一下
            for (int i = 0; i < 8; i++) {
                next[0] = temp[0] + dx[i];
                next[1] = temp[1] + dy[i];
                if (next[0] < 0 || next[1] < 0 || next[0] > qipan[0].length || next[1] > qipan.length){
                    continue;
                }else {
                    move(next);
                }
            }

        }
        //如果所有的点都不行，这一步就回退
        qipan[temp[0]][temp[1]] = 0;
        index--;
        if (index == 0 ){
            System.out.println("所有方法都试过了");
        }

    }




    public void output(){
        for (int[] x : qipan){
            for (int y : x){
                System.out.print(y+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        马走日 r = new 马走日();
        r.move(new int[2]);
    }
}
