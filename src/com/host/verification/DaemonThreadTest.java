package com.host.verification;

import java.util.concurrent.TimeUnit;

public class DaemonThreadTest {
    public static void main(String[] args){
      Thread mainThread = new Thread(() -> {
          Thread childThread = new Thread(new ChildThread());
          childThread.setDaemon(false);
          childThread.start();
          System.out.println("i am main thread");
      });
      mainThread.start();
    }
}

class ChildThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("i an child thread");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}