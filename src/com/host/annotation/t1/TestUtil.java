package com.host.annotation.t1;

/**
 * created by xiaoyao01  on 2020/5/8.
 **/
public class TestUtil {
    public static void main(String[] args) {
        UsingAnnoation root = new UsingAnnoation();
        root.setName("s");
        root.setPassword("123456");
        TestHandle.valid(root);
    }
}
