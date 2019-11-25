package com.host.algorithm;

import java.util.ArrayList;

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
    public static void main(String[] args) {
        String testEqual = "est";
        System.out.println(isEqual(testEqual));
        isContain(testEqual);
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
