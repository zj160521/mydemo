package com.demo.DesignModel.decorator;

public class Hands extends Decorator{

	public Hands(Person person) {
		super(person);
	}

	@Override
	public void personFunction() {
		super.personFunction();
		f();

	}
	
	public void f(){
		System.out.println("手");
	}
}
