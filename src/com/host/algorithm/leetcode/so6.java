package com.host.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class so6 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */
    public String convert(String s, int numRows) {
        if (s.length() == 0) return s;
        if (numRows <= 0) return "";
        if (numRows == 1) return s;
        int len = (numRows - 1) * (s.length() / (numRows + numRows - 2)) + 2;
        int newlen = s.length() / numRows;
        char[][] chars = new char[numRows + 10][s.length()];
        int shu = 0;
        int hen = -1;
        for (int i = 0; i < s.length(); i++) {
            /**
             * L
             * E   O
             * E C
             * T
             */
            if (i % (numRows + numRows - 2) == 0) {
                hen++;
                shu = 0;
                chars[shu][hen] = s.charAt(i);
                continue;
            }
            if (i % (numRows + numRows - 2) < numRows) {
                chars[++shu][hen] = s.charAt(i);
                continue;
            } else {
                chars[--shu][++hen] = s.charAt(i);
                continue;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int l = 0; l < chars.length; l++) {
            for (int n = 0; n < chars[l].length; n++) {
                if (chars[l][n] == '\u0000') sb.append(' ');
                else sb.append(chars[l][n]);
            }
            sb.append("\n");
        }
        String newstr = new String(sb);
        return newstr;
    }
    public String convert1(String s, int numRows) {
     if(numRows< 2)return s;
    List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(
    int i = 0;
    i<numRows;i++)rows.add(new

    StringBuilder());
    int i = 0, flag = -1;
        for(
    char c :s.toCharArray())

    {
        rows.get(i).append(c);
        if (i == 0 || i == numRows - 1) flag = -flag;
        i += flag;
    }

    StringBuilder res = new StringBuilder();
        for(
    StringBuilder row :rows)res.append(row);
        return res.toString();
}
    public static void main(String[] args){
      so6 s = new so6();
      System.out.println(s.convert1("PAYPALISHIRING",9));
    }
}
