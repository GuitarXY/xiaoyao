package com.cur;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by xiaoyao01  on 2020/4/27.
 **/
public class ArrayBlockingQueueTest {
    private static final int MaxLength = 10;//最大容量
    private static BlockingQueue<Integer> blockingQueue =  new ArrayBlockingQueue<Integer>(MaxLength);
    private static volatile int i = 0;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private  volatile boolean FLAG = true;



    public void produce() throws InterruptedException {
        while (FLAG){
            boolean retvalue = blockingQueue.offer(atomicInteger.incrementAndGet(), 2, TimeUnit.SECONDS);
            if (retvalue==true){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+ atomicInteger.get()+"成功"+"资源队列大小= " + blockingQueue.size());
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+ atomicInteger.get()+"失败"+"资源队列大小= " + blockingQueue.size());

            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"FLAG变为flase，生产停止");
    }

    public void consume() throws InterruptedException {
        Integer result = null;
        while (true){
            result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (null==result){
                System.out.println("超过两秒没有取道数据，消费者即将退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费"+ result+"成功"+"\t\t"+"资源队列大小= " + blockingQueue.size());
            Thread.sleep(1500);
        }

    }

    public void stop() {
        this.FLAG = false;
    }


}

class Test1{
    public static void main(String[] args) {
            ArrayBlockingQueueTest v3 = new ArrayBlockingQueueTest();
            new Thread(()->{
                try {
                    v3.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "AAA").start();

            new Thread(()->{
                try {
                    v3.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "BBB").start();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v3.stop();
        }
}
