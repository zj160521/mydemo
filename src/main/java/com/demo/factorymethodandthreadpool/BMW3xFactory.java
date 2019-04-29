package com.demo.factorymethodandthreadpool;

public class BMW3xFactory extends Factory {

	public void make() {
		// TODO Auto-generated method stub
//		System.out.println("3x");
		es.execute(new BMW3x());
	}


}
