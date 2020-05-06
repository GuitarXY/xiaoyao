package com.cur;

/**
 * created by xiaoyao01  on 2020/4/27.
 **/
//生产者与消费者
public class ProduceAndConsumer {
    private int apple = 0;
    /*
     同步的生产方法，当多个线程调用时会进入同步，锁是当前实例对象，进入前要获得实例对象锁
     */
    public synchronized void increace(){
       while (apple == 5){
           //当苹果大于5时已经进入生产最高值，当前生产的线程进行阻塞，同时释放锁
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       apple++;
        System.out.println("线程"+Thread.currentThread().getName()+"生产了一个苹果还剩"+apple);
       //通知其他获得该锁的阻塞线程，进入就绪状态
       if (apple>3){
        notify();
       }
    }
    /*
     同步的消费方法，当多个线程调用时会进入同步，锁是当前实例对象，进入前要获得实例对象锁
     */
    public synchronized void decreace(){
        while (apple == 0){
            //当苹果==0时已经进入消费最低值，当前生产的线程进行阻塞，同时释放锁
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        apple--;
        System.out.println("线程"+Thread.currentThread().getName()+"消费了一个苹果还剩"+apple);
        //通知其他获得该锁的阻塞线程，进入就绪状态
        notify();
    }
}

class Consumer extends Thread{
    public ProduceAndConsumer p;
    public Consumer(){}
    public Consumer(String name,ProduceAndConsumer p){
        this.p=p;
        super.setName(name);
    }
    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.decreace();
        }

    }
}

class Producer extends Thread{
    private String name;
    public ProduceAndConsumer p;
    public Producer(){}
    public Producer(String name,ProduceAndConsumer p){
        this.p=p;
        super.setName(name);
    }
    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.increace();
        }

    }





    static class test{
        public static void main(String[] args) {
            ProduceAndConsumer pr = new ProduceAndConsumer();
            Thread cur = new Consumer("con1",pr);
            Thread cur2 = new Consumer("con2",pr);
            Thread cur3 = new Consumer("con3",pr);

            Thread pro = new Producer("pro1",pr);
            pro.setPriority(9);

            cur.start();
            cur2.start();
            cur3.start();
            pro.start();
        }
    }

}

