package com.demo.DesignModel.factory.method;

public class BMW5xFactory implements Factory{

	@Override
	public BMW make() {
		return new BMW5x();
	}


}
