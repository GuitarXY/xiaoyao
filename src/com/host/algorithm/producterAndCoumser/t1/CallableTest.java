package com.host.algorithm.producterAndCoumser.t1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by xiaoy on 2020/1/10
 */
public class CallableTest implements Callable{

    public static void main(String[] args){
        Callable c =new CallableTest();
        FutureTask<Integer> result = new FutureTask<>(c);

        new Thread(result).start();

        try {
            int re = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object call() throws Exception {
        for (int i = 0; i< 10;i++){
            System.out.println(Thread.currentThread().getName()+" num "+i);
            if (i==6) return i;
        }
        return null;
    }
}
