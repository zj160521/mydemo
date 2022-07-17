package com.demo.designModel.decorator;

public class Decorator extends Person {

	private Person person;

	public Decorator(Person person) {
		super();
		this.person = person;
	}

	@Override
	public void personFunction() {
		person.personFunction();
	}
	
	
}
