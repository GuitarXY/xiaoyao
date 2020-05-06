package com.util;

/**
 * created by xiaoyao01  on 2020/4/24.
 **/
public class ThreadUtil {
    public static void sleepIgnoreException(int sleepTime){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
        }
    }
}
