package com.host.algorithm.多线程生产者消费者;

/**
 * Created by xiaoy on 2020/1/9
 * 给的关系是
 *      （筷子0） 0号哲学家（筷子1） 1（筷子2） 2（筷子3） 3（筷子4）
 */
public class 哲学家进餐 {
     public static void main(String[] args){
         Fork fork = new Fork();
         new Philosopher("0",fork).start();
         new Philosopher("1",fork).start();
         new Philosopher("2",fork).start();
         new Philosopher("3",fork).start();
         new Philosopher("4",fork).start();

     }
}
class Fork{
    private boolean[] used = {false,false,false,false,false};

    public synchronized void takeFork() {

        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name);
        while(used[i] || used[(i+1)%5]){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        used[i ]= true;
        used[(i+1)%5]=true;
        System.out.println("拿起来筷子"+i+"和"+(i+1)%5);

    }
    public synchronized void putFork(){
        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name);

        used[i ]= false;
        used[(i+1)%5]=false;
        System.out.println("放下了筷子"+i+"和"+(i+1)%5);
        notifyAll();//唤醒其他线程
    }
}
class Philosopher extends Thread{
    private String name;
    private Fork fork;

    public Philosopher(String name, Fork fork) {
        super(name);
        this.name = name;
        this.fork = fork;
    }

    @Override
    public void run() {
        while (true){
            thinking();
            fork.takeFork();
            eating();
            fork.putFork();
        }
    }
    public void eating(){
        System.out.println("I am Eating:"+name);
        try {
            sleep(1000);//模拟吃饭，占用一段时间资源
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void thinking(){
        System.out.println("I am Thinking:"+name);
        try {
            sleep(1000);//模拟思考
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}