package com.cur.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by xiaoyao01  on 2020/5/6.
 **/
public class ReentrantLockTest {
    private static final Lock lock = new ReentrantLock();
    public static void mainx(String[] args) {
        new Thread(() -> testx(),"线程A").start();
        new Thread(() -> testx(),"线程B").start();
    }
    //随机

    private static void testx() {
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"获得了锁");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }


    private static final Lock lock1 = new ReentrantLock(true);
    public static void main(String[] args) {
        new Thread(() -> test1(),"线程A").start();
        new Thread(() -> test1(),"线程B").start();
        new Thread(() -> test1(),"线程c").start();
        new Thread(() -> test1(),"线程d").start();
    }
    //公平
    private static void test1() {
        for(int i = 0; i < 2; i++){
            lock1.lock();
            System.out.println(Thread.currentThread().getName()+"获得了锁");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+"释放了锁");
                lock1.unlock();
            }
        }
    }







}
