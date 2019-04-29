package com.demo.DesignModel.factory.method;

public class BMW7xFactory implements Factory{

	@Override
	public BMW make() {
		return new BMW7x();
	}


}
