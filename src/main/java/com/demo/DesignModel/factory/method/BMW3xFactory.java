package com.demo.DesignModel.factory.method;

public class BMW3xFactory implements Factory{

	public BMW make() {
//		System.out.println("3x");
		return new BMW3x();
	}


}
