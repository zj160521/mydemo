package com.demo.factorymethodandthreadpool;

public class BMW5xFactory extends Factory{

	@Override
	public void make() {
		// TODO Auto-generated method stub
		es.execute(new BMW5x());
	}


}
