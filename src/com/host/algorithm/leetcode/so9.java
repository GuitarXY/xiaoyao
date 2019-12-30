package com.host.algorithm.leetcode;

/**
 * Created by xiaoy on 2019/11/25
 * 一个数字是不是回文字符串
 * 123 不是
 * -123 不是
 * 121 是
 */
public class so9 {
    public static  boolean isPalindrome(int x) {
      if (x < 0) return false;
      int res = 0;
      int num = x;
      while (x != 0){
          res = res*10 + x%10;
          x = x/10;
      }
      return num == res;

    }
    public static void main(String[] args){
        System.out.println(isPalindrome(121));
    }
}
