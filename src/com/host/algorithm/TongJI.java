package com.host.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TongJI {
    /**
     * 统计每个文章内每个字符出现的次数
     */
    public static Map statistics(String path) throws IOException {
        FileReader fr = null;
        Map<Character,Integer> map = new HashMap<>();
        try {
            fr = new FileReader(new File(path));
            char[] c = new char[128];
            int len = -1;
            while((len = fr.read(c)) != -1){
                //System.out.println(new String(c,0,len));
                char[] temp= new String(c,0,len).trim().toCharArray();
                for(char t : temp){
                    if(map.get(t)!=null){
                        int num = map.get(t)+1;
                        map.put(t,num);
                    }else{
                        map.put(t,1);
                    }
                }

            }
            Set<Map.Entry<Character,Integer>> set = map.entrySet();
            for(Map.Entry en : set){
                System.out.println("key:"+en.getKey()+"nums:"+en.getValue());;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(fr!=null)fr.close();
        }
        return null;
    }


    public static void main(String[] args){
//        try {
//            statistics("D:\\IntelliJ IDEA 2018.2.7\\1idea_project\\jczh\\src\\sql.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//       String str = "kasdkasdkfh";
//        while (str.length()!=0){
//            int le = str.length() - str.replace(str.charAt(0)+"","").length();
//            System.out.println(str.charAt(0)+":"+le);
//             str=str.replace(str.charAt(0)+"","");
//       }

        System.out.println("a\ra");


    }
}
