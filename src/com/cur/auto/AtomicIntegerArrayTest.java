package com.cur.auto;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.LongAdder;

/**
 * created by xiaoyao01  on 2020/4/27.
 **/
public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        AtomicIntegerArray arr = new AtomicIntegerArray(5);
        int i = 0;
        i = arr.addAndGet(1, 3);
        System.out.println(i);
        System.out.println(arr.get(1));
        System.out.println(Runtime.getRuntime().availableProcessors());
        LongAdder adder = new LongAdder();
    }
}
