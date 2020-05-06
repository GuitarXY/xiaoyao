package com.cur.auto;

import java.util.concurrent.atomic.AtomicReference;

/**
 * created by xiaoyao01  on 2020/4/27.
 **/
public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicReference<Long> a = new AtomicReference<>(132123123L);
        System.out.println(a.get());
        Long i = a.getAndSet(100L);
        System.out.println(i);
        System.out.println(a.get());
        a.compareAndSet(100L,101L);
        System.out.println(a.get());

        System.out.println(a.accumulateAndGet(100L,(pre,next)->pre*next));//next - >10100
        System.out.println(a.get());

        AtomicReference<student> s1 = new AtomicReference<>(new student());
    }
}


class student{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
