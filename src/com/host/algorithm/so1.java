package com.host.algorithm;

import java.util.Date;

/**
 * Created by xiaoy on 2019/12/17
 */
public class so1 {//给定一个数组，里面有一半的数是一个值，找出这个值

    public static void main1(String[] args){
        System.out.println("s 00 1".trim());
        System.out.println(new Date());
        int[] a = {4,4,4,8,1,4,2,5,3,1,4,4};
        //遍历这个数组，两个不同的就删去，这样新数组也是那个数超过一般
        int val = -1;
        int time = 0;
        for (int i = 0; i< a.length; i++){
            if (time == 0){
                val = a[i];
                time ++;
                continue;
            }
            if (val == a[i]){
                time ++;
            }else {
                time--;
            }
        }
        System.out.println(val);;

    }
    public static void main(String[] args){
      String s = "abc";
      String re = new StringBuffer(s).reverse().toString();
      System.out.println(re);
    }

}
