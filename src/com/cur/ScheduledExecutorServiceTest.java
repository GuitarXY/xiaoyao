package com.cur;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * created by xiaoyao01  on 2020/4/23.
 **/
public class ScheduledExecutorServiceTest {
    private static ScheduledExecutorService mScheduledExecutorService = Executors.newScheduledThreadPool(4);

    public static void main(String[] args) {
//        mScheduledExecutorService.schedule(
//                new Runnable() {
//                    public void run() {
//                        System.out.println("111");
//                    }
//                },3, TimeUnit.SECONDS
//        );
//        mScheduledExecutorService.scheduleAtFixedRate(
//                new Runnable() {
//                    public void run() {
//                        System.out.println("433");
//                    }
//                }, 2, 2, TimeUnit.SECONDS
//        );
        mScheduledExecutorService.scheduleWithFixedDelay(
                new Runnable() {
                    public void run() {
                        try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                       e.printStackTrace();
                    }
                        System.out.println("433"+System.currentTimeMillis() / 1000);
                    }
                }, 2, 4, TimeUnit.SECONDS
        );
        new Runnable() {
            public void run() {
                int i=0;
                while (true){

                    System.out.println(i++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.run();
    }
}
