package com.host.moshi.Singleton;

/**
 * Created by xiaoy on 2019/11/30
 */
public class SevenSigleton {
}
class Singleton1 {

    private Singleton1(){}

    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance(){
        return instance;
    }
}
class Singleton2 {

    private Singleton2(){}

    private static Singleton2 instance;

    public static Singleton2 getInstance(){
        if(instance == null){

            instance = new Singleton2();
        }
        return instance;
    }
}

class Singleton3 {

    private Singleton3(){}

    private static Singleton3 instance;

    public synchronized static Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}

class Singleton4 {

    private Singleton4(){}

    private static Singleton4 instance;

    public static Singleton4 getInstance(){

            if(instance == null){
                synchronized(Singleton4.class){
                    if(instance == null){
                        instance = new Singleton4();
                    }
                }
            }
            return instance;
        }
}

//volatile关键字能够禁止指令重排，保证在写操作没有完成之前不能调用读操作。
class Singleton5 {

    private Singleton5(){}

    private static volatile Singleton5 instance;

    public static Singleton5 getInstance(){
        if(instance == null){
            synchronized(Singleton5.class){
                if(instance == null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
class Singleton6 {

    private Singleton6(){}

    /**
     * ，它的初始化操作跟外部类是分开的。在没有调用 getInstance() 方法之前，
     * 静态内部类不会进行初始化，在第一次调用该方法后就生成了唯一一个实例。
     */
    private static class SingletonHolder {
        private static Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return SingletonHolder.instance;
    }
}

 enum Singleton7 {

    INSTANCE;

    public void fun(){}

}







