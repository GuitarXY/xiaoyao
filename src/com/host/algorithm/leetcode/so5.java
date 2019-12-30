package com.host.algorithm.leetcode;

import javax.activation.MailcapCommandMap;

/**
 * Created by xiaoy on 2019/11/25
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class so5 {
    /**
     * 方法1，暴力破解法
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        String  ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++){
            for (int j = i+1 ; j <= len; j++){
                String test = s.substring(i,j);
                if (isPalindrome1(test) && test.length() > max){
                    ans = test;
                    max = test.length();
                }
            }
        }
        return ans;
    }

    //判断这个字符是不是回文字符
    private boolean isPalindrome1(String test) {
        int i = 0,j = test.length()-1;
        while(i <= j){
            if (test.charAt(i) == test.charAt(j)){
                i++;
                j--;}
            else break;
        }
        if (i <= j) return false;
        else return true;

    }

    /**
     * 动态规划算法
     * arr [ i ][ j ] 保存的就是公共子串的长度。
     * a[i][j+1] = a[i+1][j] && S[i]===S[j+1x`]
     * a[i+1][j+1] = arr [ i ][ j ]&& S[i]==S[j]
     * S[i]==S[j]true
     */
    public String longestPalindrome2(String s) {
        String orgin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxlen = 0;
        int maxend = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++){
                if (orgin.charAt(i) == reverse.charAt(j)){
                    if (i == 0 || j == 0){
                        arr [i][j] = 1;//代表回文字符串暂时回文数为1--> a  aa
                    }else{
                        arr[i][j] = arr[i - 1][j - 1] + 1;//之前的回文数+1
                    }
                    if (arr[i][j] > maxlen){
                        //更新
                        int beforRev = length - 1 - j;
                        if (beforRev + arr[i][j] - 1 == i ){//判断下标是否对应的
                            maxlen = arr[i][j];
                            maxend = i;
                        }
                    }
                }
            }
        return s.substring(maxend - maxlen + 1, maxend + 1);
    }

    public static void main(String[] args){
      System.out.println("asdasd".substring(5,6));
    }

}
