package com.demo.DesignModel.decorator;

public class Feet extends Decorator {

	public Feet(Person person) {
		super(person);
	}

	@Override
	public void personFunction() {
		super.personFunction();
		System.out.println("脚");
	}
}
