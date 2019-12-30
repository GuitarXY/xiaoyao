package com.host.algorithm;

public class testStringSplit {
    public static void main(String[] args){
        String t = "a,b,,c,d,,,";
        String[] split = t.split(",");
        for (String te : split){
            System.out.println(te);
        }
        System.out.println(split.length);

        int i=1;
        boolean re = false & true || i++==2 && false & ++i==3;
        System.out.println(re);
        System.out.println(i);
    }


}
