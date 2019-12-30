package com.host.moshi.Factory.Factory;
/**
 *..................................
 *          ���汣��             ����BUG
 *xiaoyao
 */
public class FactoryTest {
	public static void main(String[] args) {
		Factory factory=new BWMFactory();
		//Car car=BWMFactory.makeCar();
		Car BWM=factory.makeCar();
		BWM.getCar();
	}
}
