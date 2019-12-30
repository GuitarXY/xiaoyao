package com.host.moshi.Singleton;

import java.io.Serializable;

/**
 *..................................
 *          佛祖保佑             永无BUG
 *xiaoyao
 */
public class safeSingleton implements Serializable {
	private static safeSingleton mInstance;
	private safeSingleton() {
		if(mInstance!=null)
			throw new RuntimeException("你不能反射单例");

	}

	public static safeSingleton getInstance() {
		if(mInstance==null)
			synchronized (safeSingleton.class) {
				if(mInstance==null) mInstance=new safeSingleton();
			}
		return mInstance;

	}

	//Serializable重写方法防止反序列化破坏单例
	protected  Object readResolve() {
		return getInstance();

	}
}
