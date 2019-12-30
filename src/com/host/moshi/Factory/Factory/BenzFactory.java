package com.host.moshi.Factory.Factory;
/**
 *..................................
 *          ���汣��             ����BUG
 *xiaoyao
 */
public class BenzFactory implements Factory {

	@Override
	public Car makeCar() {
		
		return new BenzCar();
	}

}
