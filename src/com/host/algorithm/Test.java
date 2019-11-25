package com.host.algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);


        System.out.println(dateString);
    }
}
