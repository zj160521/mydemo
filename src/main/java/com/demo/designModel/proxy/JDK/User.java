package com.demo.designModel.proxy.JDK;

public class User implements IUser{

	public void show() {
		// TODO Auto-generated method stub
		System.out.println("张三");

	}

	@Override
	public void time() {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
	}

}
