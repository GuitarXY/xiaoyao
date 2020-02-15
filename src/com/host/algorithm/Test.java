package com.host.algorithm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public static void main1(String[] args){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);

        Queue queue = new LinkedList();
        System.out.println(dateString);
    }
    public static void main2(String[] args){
        int s = 70;
       if (s>50){
           //50-60
           System.out.println("the score:"+(s*0.5+50));
       }else if(s>60){
           //60-70

       }else if(s>70){

       }else if (s>80){

       }else {
           //分数小于50
       }
    }
    public static void main3(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = Integer.parseInt(s);
        HashMap map = new HashMap();
       // map.putMapEntries(map,true);

    }
    public static void main(String[] args){
        try {
            MessageDigest md =MessageDigest.getInstance("md5");
            String s = "hello";
            byte[] bytes = s.getBytes();
            byte[] digest = md.digest(bytes);
            String re = new BigInteger(digest).toString(16);
            System.out.println(re);
            for (int i = 0; i< 32 -re.length();i++){
                re = 0+re;
            }
            System.out.println(re);


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
