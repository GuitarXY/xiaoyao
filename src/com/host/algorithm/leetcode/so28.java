package com.host.algorithm.leetcode;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 */
public class so28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null) return 0;
        if (needle == null) return 0;
        if ("".equals(needle)&&"".equals(haystack))
            return 0;
        if ("".equals(haystack))
            return -1;

        int lenhay = haystack.length();
        int len = needle.length();
        int start = 0;
        int end = len-1;
        if (len > lenhay) return -1;
        while(end < lenhay){
            if(haystack.substring(start,end+1).equals(needle))
                return start;
            start++;
            end++;
        }
        return -1;

    }
    public static void main(String[] args){
        so28 s = new so28();
        System.out.println(s.strStr("hahahha","hh"));
    }
}
