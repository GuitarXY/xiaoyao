package com.cur;

/**
 * created by xiaoyao01  on 2020/4/27.
 **/
public class Test {
    public static void main(String[] args) {
        tr t11 = new tr("t11");
        tr t22 = new tr("t22");
        Thread t1 = new Thread(t11);
        t1.setPriority(8);
        Thread t2 = new Thread(t22);
        t1.run();
        t2.run();


    }
}

class tr extends Thread{
    public String name;
    public static volatile int i=100;
    public tr(String name){
        this.name = name;
    }
    public void run(){
        while (i>0){
            synchronized (tr.class){

                //Thread.currentThread().getName()  main
                System.out.println(name+"--i:"+i);
                i--;
                try {
                    tr.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        }
    }
}
