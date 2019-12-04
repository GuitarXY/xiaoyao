package com.host.moshi.Singleton;

import java.io.*;

/**
 *..................................
 *          佛祖保佑             永无BUG
 *xiaoyao
 */
public class DCLSingleton implements Serializable{
	private static DCLSingleton mInstance;
	private DCLSingleton() {};

	/**
	 * 双重检查锁定的运用，因为懒汉式不管是不是多线程一律加锁增加
	 * 了额外的性能消耗，DCL应运而生
	 * @author xiaoyao
	 * @return
	 */
	public static DCLSingleton getInstance() {
		/*
		 * 第一次判断，如果已经实例话了，直接返回，
		 */
		if(mInstance==null) {
			//对实例化过程做同步操作，保证单例
			synchronized (DCLSingleton.class) {
				if(mInstance==null) mInstance=new DCLSingleton();
			}
		}
		return mInstance;
		//缺陷，重排序导致多线程访问可能获得一个未初始化的对象



	}
	public static void main(String[] args) {
		//然而双重校验并不能防止反射
		DCLSingleton d1=DCLSingleton.getInstance();
		DCLSingleton d2=null;
//不能阻止反射
//		try {
//			Class<DCLSingleton> clazz=DCLSingleton.class;
//			Constructor<DCLSingleton> constructor = clazz.getDeclaredConstructor();
//			constructor.setAccessible(true);
//			d2=constructor.newInstance();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(d1);
//		System.out.println(d2);


		//同时也不能阻止序列化
		try {
			ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream("./a.txt")) ;
			oop.writeObject(d1);
			oop.close();

			ObjectInputStream oip=new ObjectInputStream(new FileInputStream("./a.txt")) ;
			d2=(DCLSingleton) oip.readObject();


		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(d1);
		System.out.println(d2);
	}
}
