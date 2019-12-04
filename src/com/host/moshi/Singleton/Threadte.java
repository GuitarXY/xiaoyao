package com.host.moshi.Singleton;
/**
 *..................................
 *          ���汣��             ����BUG
 *xiaoyao
 */
public class Threadte extends Thread {
	public void run() {
		for(int i=0;i<1000;i++) {
		DCLSingleton s=DCLSingleton.getInstance();
		System.out.println(s);
		}
	}
}
