package com.host.moshi.Factory.Factory;
/**
 *..................................
 *          ���汣��             ����BUG
 *xiaoyao
 */
public class BWMFactory implements Factory {

	@Override
	public  Car makeCar() {
		// TODO Auto-generated method stub
		return new BWMCar();
	}

}
