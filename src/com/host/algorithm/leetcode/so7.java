package com.host.algorithm.leetcode;

public class so7 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * 注意，如过反转后整数溢出就返回0
     */
    public int reverse(int x){
        if (x > 0) {
            String temp = Integer.toString(x);
          //  System.out.println(temp);
            String s = reverseString(temp);
            Long l = Long.parseLong(s);
            if (l>Integer.MAX_VALUE)return 0;
            else return Integer.parseInt(s);
        }else if (x < 0){
            String temp = Integer.toString(x);
            String s = reverseString(temp.substring(1,temp.length()));
            Long l = Long.parseLong(s);
            l = -l;
            if (l<Integer.MIN_VALUE)return 0;
            else return -Integer.parseInt(s);
        }
        return 0;
    }

    private String reverseString(String temp) {
        if (temp.length()==1) return temp;
        else if (temp.length()%2==1){
            String newStr0 = reverseString(temp.substring(temp.length()/2+1,temp.length()));
            String newStr1 =               temp.substring(temp.length()/2,temp.length()/2+1);
            String newStr2 =       reverseString(temp.substring(0,temp.length()/2));
            return newStr0+newStr1+newStr2;
        }else {
            String newStr = reverseString(temp.substring(temp.length()/2,temp.length()))+
                    reverseString(temp.substring(0,temp.length()/2));

            return newStr;
        }
    }
    public static void main(String[] args){
        so7 s = new so7();
        //System.out.println(s.reverse(1231));
        System.out.println(s.reverseString("12314"));
        System.out.println("asdasds".substring(4,7));
    }
}
