package com.host.algorithm;

import java.util.Stack;

/**
 * Created by xiaoy on 2019/12/20
 */
public class 判断栈的弹出顺序 {
    public static  boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for(int i = 0 ;i < pushA.length; i++){
            s.push(pushA[i]);
            while(popA[j] == s.peek()){
                if(j == popA.length - 1) return true;
                s.pop();    
                j++;
            }


        }

        return false;




    }
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        IsPopOrder(a,b);
    }
}
