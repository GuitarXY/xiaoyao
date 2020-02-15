package com.host.algorithm.多线程生产者消费者.t1;

import java.util.concurrent.*;

/**
 * Created by xiaoy on 2020/1/10
 */
public class 线程池 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> c = new CallableTest();
        Callable<Integer> c1 = ()->{
            Thread.sleep(3000);
            return 100;
        };
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Integer> re  =  service.submit(c);
        System.out.println(re.get());
    }
}
