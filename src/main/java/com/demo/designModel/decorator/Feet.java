package com.demo.designModel.decorator;

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
