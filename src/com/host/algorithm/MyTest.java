package com.host.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class MyTest {

    static ArrayList<String> list = new ArrayList<>();
    static {
        list.add("test");
        list.add("t");
        list.add("e");
        list.add("s");
        list.add("t");
        list.add(null);
    }

    //程序运行入口
    public static void main1(String[] args) {
        String testEqual = "est";
        System.out.println(isEqual(testEqual));
        isContain(testEqual);
    }
    public static void main(String[] args){
        Double weightCount = 0.123d;
        Double weightCount1 = 4.254;
        BigDecimal d = new BigDecimal("0").add(new BigDecimal(weightCount1)).setScale(3,BigDecimal.ROUND_HALF_UP);
        System.out.println(d);
        BigDecimal e = new BigDecimal("1").add(new BigDecimal(weightCount));
        System.out.println(e);
        System.out.println(Double.parseDouble("0.123"));
        System.out.println(Integer.toBinaryString(10));

    }

    //判断等于
    public static boolean isEqual(String str){
        return str.equals("test");
    }

    //判断包含
    public static boolean isContain(String str){
        if (list.size() > 0 && list != null) {
            //遍历list
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) != null)
                if (str.equals(list.get(i))) {
                    System.out.println("集合中包含:" + str);
                    return true;
                }
            }
        }
        System.out.println("集合中不包含:" + str);
        return true;
    }

}
