package com.host.moshi.Factory.AbstractFactory;
/**
 *..................................
 *          ���汣��             ����BUG
 *xiaoyao
 */
public class Factory2 extends Factory{

	@Override
	public Flyable createFlyable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Moveable createMoveable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Writeable createWriteable() {
		// TODO Auto-generated method stub
		return new Pencli();
	}

}
