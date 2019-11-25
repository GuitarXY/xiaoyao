package com.host.algorithm.leetcode;

public class so1114 {
    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();
    public so1114(){
    }

    public void first(Runnable printFirst){
        printFirst.run();
    }
    public void second(Runnable printSecond){
        printSecond.run();
    }
    public void third(Runnable printThird){
        printThird.run();
    }
    public static void main(String[] args){
          Runnable f = new Runnable() {
              @Override
              public void run() {


                  System.out.println("111");
              }
          };
          Runnable s = new Runnable() {
                @Override
                public void run() {
                    System.out.println("222");

                }
          };
          Runnable t = new Runnable() {
                @Override
                public void run() {
                    System.out.println("333");
                }
          };
          so1114 so = new so1114();

  //       so.first(f);
//          so.second(s);
//          so.third(t);
          Thread t1 = new Thread(f);
          t1.start();

          Thread t2 = new Thread(s);
          t2.start();
          Thread t3 = new Thread(t);
          t3.start();

    }
}
