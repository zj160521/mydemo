package com.demo.DesignModel.builder;

public interface Builder {

	public void buildHead();
	public void buildBody();
	public void buildFoot();
	
	Person buildPerson();
}
