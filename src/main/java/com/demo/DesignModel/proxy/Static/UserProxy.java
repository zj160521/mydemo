package com.demo.DesignModel.proxy.Static;

public class UserProxy implements IUser {

	private IUser iUser;
	
	public UserProxy(IUser iUser) {
		this.iUser = iUser;
	}


	@Override
	public void show() {
		System.out.println("start");
		iUser.show();
		System.out.println("end");
	}

}
