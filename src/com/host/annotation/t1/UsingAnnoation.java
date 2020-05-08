package com.host.annotation.t1;

/**
 * created by xiaoyao01  on 2020/5/8.
 **/
public class UsingAnnoation {
    @Test(min = 6, max =10, description = "用户名长度在6-10")
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
