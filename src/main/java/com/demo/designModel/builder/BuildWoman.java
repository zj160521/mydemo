package com.demo.designModel.builder;

public class BuildWoman implements Builder {

	Person person;

	public BuildWoman() {
		person = new Person();
	}

	@Override
	public void buildHead() {
		// TODO Auto-generated method stub
		person.setHead("瓜子脸");
	}

	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		person.setBody("前凸后翘");
	}

	@Override
	public void buildFoot() {
		// TODO Auto-generated method stub
		person.setFoot("小脚");
	}

	@Override
	public Person buildPerson() {
		// TODO Auto-generated method stub
		return person;
	}

}
