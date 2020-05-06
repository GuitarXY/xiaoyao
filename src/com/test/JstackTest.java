package com.test;


import com.util.ThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by xiaoyao01  on 2020/4/24.
 **/
public class JstackTest {
    //dead Thread
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(() -> {
            lock1.lock();
            ThreadUtil.sleepIgnoreException(1000);
            lock2.lock();

            lock2.unlock();

            lock1.unlock();

        });

        service.execute(() -> {
            lock2.lock();
            ThreadUtil.sleepIgnoreException(1000);
            lock1.lock();
            lock1.unlock();

            lock2.unlock();
        });
    }
}
