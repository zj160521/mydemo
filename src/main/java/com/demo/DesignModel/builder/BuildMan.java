package com.demo.DesignModel.builder;

public class BuildMan implements Builder {

	Person person;

	public BuildMan() {
		person = new Person();
	}

	@Override
	public void buildHead() {
		// TODO Auto-generated method stub
		person.setHead("头大");
	}

	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		person.setBody("强壮");
	}

	@Override
	public void buildFoot() {
		// TODO Auto-generated method stub
		person.setFoot("脚长");
	}

	@Override
	public Person buildPerson() {
		// TODO Auto-generated method stub
		return person;
	}

}
