package com.host.algorithm.多线程生产者消费者;

/**
 * Created by xiaoy on 2020/1/9
 */
public class Consumer {
    private Count c;
    private Object lock;

    public Consumer(Count c,Object lock) {
        this.c = c;
        this.lock = lock;
    }

    public Consumer() {
    }

    public void sub(){
        synchronized (lock){
            if (c.getCount() > 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c.setCount(c.getCount()-1);
                System.out.println(Thread.currentThread().getName()+"消费了1还有"+c.getCount());
                lock.notifyAll();

            }else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
