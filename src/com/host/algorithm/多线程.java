/*
package com.host.algorithm;

*/
/**
 * Created by xiaoy on 2019/12/27
 *//*

public class 多线程 {
    private static int a = 0,b =0;
    private static int x = 0,y =0;
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (;;){
            i++;
            x = 0;y = 0;
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    a = 1;
                    x = b;
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b= 1;
                    y = a;
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("第"+ i + "次(" + x + "," + y +")");
        }

    }
}
*/
