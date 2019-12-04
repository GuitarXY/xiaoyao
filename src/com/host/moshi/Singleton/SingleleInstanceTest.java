package com.host.moshi.Singleton;


/**
 *..................................
 *          佛祖保佑             永无BUG
 *xiaoyao
 */

public class SingleleInstanceTest {


	public static void main(String[] args) {
		Single s1=Single.getsingle();
		Single s2=Single.getsingle();
		Single s3=Single.getsingle();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}

class Single{
	public static Single single;
	//饿汉shi，注意要防止克隆
	static {
		if(single==null)
			single=new Single();
	}
	private Single() {
		System.out.println("单例");
	}
	public static  Single getsingle()
	{//懒汉式单例,线程不安全做到延迟加载，但牺牲了枷锁的时间
		//		if(single==null)
		//			single=new Single();

		return single;
	}
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {

			Threadte t=new Threadte();
			t.start();
		}
	}

}









