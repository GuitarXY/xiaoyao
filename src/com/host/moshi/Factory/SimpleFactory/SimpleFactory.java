package com.host.moshi.Factory.SimpleFactory;
/**
 *..................................
 *          ���汣��             ����BUG
 *xiaoyao
 */
public class SimpleFactory {
	public Car makeCar(String car) {
		if(car.equals("BWM")) {
			return new BWMCar();
		}
		if(car.equals("Benz"))
		{
			return new BenzCar();
		}
		else{
			System.out.println("造不出来");
			return null;
		}
	}
}
