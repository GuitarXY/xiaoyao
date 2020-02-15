package com.host.algorithm.多线程生产者消费者;
/**
 * Created by xiaoy on 2020/1/9
 */
public class Run {
    public static void main(String[] args){
      Count c = new Count();
      Object lock = new Object();
      Consumer consumer = new Consumer(c,lock);
      Producer producer = new Producer(c,lock);

      new Thread(new Runnable() {
          @Override
          public void run() {
              while (true){
                  consumer.sub();
              }
          }
      },"c1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    consumer.sub();

                }
            }
        },"c2").start();
      new Thread(new Runnable() {
          @Override
          public void run() {
              while (true){
                  producer.add();

              }
          }
      },"p1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    producer.add();

                }
            }
        },"p2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    producer.add();

                }
            }
        },"p3").start();


    }
}
