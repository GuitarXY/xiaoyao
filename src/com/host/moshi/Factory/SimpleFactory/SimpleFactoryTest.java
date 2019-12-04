package com.host.moshi.Factory.SimpleFactory;
/**
 *..................................
 *          ���汣��             ����BUG
 *xiaoyao
 */
public class SimpleFactoryTest {
	public static void main(String[] args) {
		SimpleFactory factory=new SimpleFactory();
		Car bwm=factory.makeCar("BWM");
		bwm.getCar();
		Car jeep=factory.makeCar("Jeep");
	}
}
