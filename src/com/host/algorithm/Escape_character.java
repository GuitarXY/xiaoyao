package com.host.algorithm;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Escape_character {
    public static void main(String[] args){
      System.out.println("转义回车 \\r:\r");
      System.out.println("a\fa");
      System.out.println("\u0024");
      System.out.println("a\ta");
     Lock lock = new ReentrantLock();

//        Condition condition = lock.newCondition();lock.lock();lock.unlock();
//        condition.signal();
//        volatile;Object o = new Object();
//o.wait();
//        CountDownLatch
//synchronized ()
    }
}
