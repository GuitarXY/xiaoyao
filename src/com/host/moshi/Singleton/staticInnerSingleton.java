package com.host.moshi.Singleton;


/**
 *..................................
 *          佛祖保佑             永无BUG
 *xiaoyao
 */
public class staticInnerSingleton {
	private staticInnerSingleton() {}
	private static class single{
		private static final staticInnerSingleton s=new
				staticInnerSingleton();

	}
	public static staticInnerSingleton getInstance() {
		//静态内部类模式获得单利
		return single.s;
	}

	public static void main(String[] args) {
		staticInnerSingleton s1=staticInnerSingleton.getInstance();
		staticInnerSingleton s2=staticInnerSingleton.getInstance();
		System.out.println(s1);
		System.out.println(s2);
	}



}

