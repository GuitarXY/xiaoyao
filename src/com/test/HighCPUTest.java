package com.test;


import com.util.ThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by xiaoyao01  on 2020/4/24.
 **/
public class HighCPUTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            int i = 0;
            while (true)
                i++;
        });
        service.execute(() -> {
            int i = 0;
            while (true) {
                i++;
                ThreadUtil.sleepIgnoreException(1000);
            }
        });
    }
}
