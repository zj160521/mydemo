package com.demo.factorymethodandthreadpool;

public class BMW7xFactory extends Factory{

	@Override
	public void make() {
		es.execute(new BMW7x());
	}


}
