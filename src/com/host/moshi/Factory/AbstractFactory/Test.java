package com.host.moshi.Factory.AbstractFactory;
/**
 *..................................
 *          ���汣��             ����BUG
 *xiaoyao
 */
public class Test {
	public static void main(String[] args) {
		Factory f1=new Factory1();
		Factory f2=new Factory2();
		Writeable a1=f1.createWriteable();
		Writeable a2=f2.createWriteable();
		a1.write();
		a2.write();
		
	}
}
