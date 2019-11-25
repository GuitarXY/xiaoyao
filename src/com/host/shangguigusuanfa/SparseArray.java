package com.host.shangguigusuanfa;

/**
 * Created by xiaoy on 2019/11/20
 * 普通数组到稀疏数组的转化
 * 稀疏数组：第一行表示原数组的所有列，行值，以及有效值
 * 后面每一列表示一个有效值
 */
public class SparseArray {
    public static void main(String[] args){
        //创建一个原始的二维数组11*11
        //0表示黑子.1表示白子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[2][4] = 5;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int i = 0;i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                System.out.print(chessArr[i][j] + "   ");
            }
            System.out.println();
        }

        //转化为稀疏数组
        //1遍历二维数组，得到非零的个数
        int sum = 0;
        for (int i = 0;i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if(chessArr[i][j] != 0){
                    sum ++;
                }
            }
        }
        //创建对应的稀疏数组
        int[][] sparseArray = new int [sum+1][3];
        sparseArray[0][0] = chessArr.length;
        sparseArray[0][1] = chessArr[0].length;
        sparseArray[0][2] = sum;
        int s = 1;
        for (int i = 0;i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if(chessArr[i][j] != 0){
                    sparseArray[s][0] = i;
                    sparseArray[s][1] = j;
                    sparseArray[s][2] = chessArr[i][j];
                   s++;
                }
            }
        }
        System.out.println("稀疏数组");
        for (int[] xs : sparseArray ){
            System.out.printf("%d\t%d\t%d\t\n",xs[0],xs[1],xs[2]);
        }
    }
}
