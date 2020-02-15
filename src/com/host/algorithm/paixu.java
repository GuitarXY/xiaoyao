package com.host.algorithm;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.HashMap;

/**
 * Created by xiaoy on 2019/12/30
 */
public class paixu {
    public static void main(String[] args){

        int[] list = {5,1,9,6,2,8,8,10,4,3,7};
        //maopao(list);
        //xuanze(list);
        //charu(list);??
        //kuaisu(list);
           guibing(list);
//        tong(list);
       // xier(list);
        for (int i : list){
            System.out.print(i+"  ");
        }
    }

    private static void guibing(int[] list) {
        int temp[] = new int[list.length];
        gb(list,temp,0,list.length-1);
    }

    /**
     * 归并排序，先递归到最小，拍好序列后就比较好比较了
     * @param arr
     * @param start
     * @param end
     */
    private static void gb(int[] arr, int[] reg,int start, int end) {
        if (start >= end) return;
        int mid = (start+end)>>1;

        gb(arr, reg, start, mid);
        gb(arr, reg, mid+1, end);
        int k = start;
        int i = start,j = mid+1;
        while (i <= mid && j <= end)
            reg[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        while (i <= mid)
            reg[k++] = arr[i++];
        while (j <= end)
            reg[k++] = arr[j++];
        for (k = start; k <= end; k++)
            arr[k] = reg[k];

    }

    private static void kuaisu(int[] list) {
        //快排，随机选一个作为基础,
        // 使得所有小于他的在这个数前面，大于他的在这个数后面
       kp(list,0,list.length-1);

    }

    /**
     * 快速排序，start是排序起始位置，end是结束位置
     * @param list
     * @param start
     * @param end
     */
    private static void kp(int[] list, int start, int end) {
        if(start >= end) return;
        int stander = list[end];
        int i = start ; int k = end-1;
        while(i < k){
            while (list[i] < stander && i < k)
                i++;
            while (list[k] >= stander && i < k)
                k--;
            int temp = list[i];
            list[i] = list[k];
            list[k] = temp;

        }
        if (list[i] >stander){

            list[end] = list[i];
            list[i] = stander;
            kp(list,0,i-1);
            kp(list,i+1,end);
        }else {
            list[end] = list[i+1];
            list[i+1] = stander;

            kp(list,0,i);
            kp(list,i+2,end);
        }



    }

    private static void xier(int[] list) {
        //希尔排序，递减增量排序法
        int len = list.length;
        for(int i = len>>1 ; i > 0 ; i = i>>1) {
            for (int j = i; j < len; j++){
                int temp = list[j];
                int k;
                for ( k = j-i; k>=0&&list[k]>temp;k = k-i){
                    list[k+i] = list[k];
                }
                list[k+i] = temp;
            }
        }
    }

    private static void charu(int[] list) {

        for (int i = 1; i < list.length; i++ ){
            int m = list[i];
            int j;
            for (j = i; j > 0 && list[j-1] > m;j--){
                list[j] = list[j-1];
                //把j的这个位置让出来给i
            }

            list[j] = m;

        }

    }

    private static void xuanze(int[] list) {
        for (int i = 0; i < list.length-1; i++ ){
            int minIndex = i;
            for(int j = i+1; j < list.length; j++){
                if (list[minIndex] > list[j] ){
                    minIndex = j;
                }
            }
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;

        }

    }

    private static void maopao(int[] list) {
        for (int i = 0; i < list.length; i++ ){
            for(int j = i+1; j < list.length; j++){
                if (list[i] > list[j]){
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }

            }
        }
    }
}
