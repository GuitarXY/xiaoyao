package com.host.algorithm.leetcode;

public class so459 {
    /*
    * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
        示例 1:
        输入: "abab"
        输出: True
        解释: 可由子字符串 "ab" 重复两次构成。
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s.length()==1) return false;
        for (int i = 1; i<=s.length()/2; i++){
            String s1 = s.substring(0,i);
            String re = s.replace(s1,"");
            int len = re.length();
            if (len==0)return true;
        }
        return false;
    }
    public boolean check(String s){
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
    public static void main(String[] args){
        so459 ne = new so459();
        System.out.println(ne.repeatedSubstringPattern("babbabbabbabbab"));//如果字符串太大计算超出时间限制
        System.out.println(ne.check("sasasa"));
    }


}
