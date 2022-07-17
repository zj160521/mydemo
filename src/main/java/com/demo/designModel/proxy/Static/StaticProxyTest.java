package com.demo.designModel.proxy.Static;

public class StaticProxyTest {
	//静态代理总结:
	//	1.代理类可以控制目标类的输出，去增强或者，减弱
	//	2.缺点:因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护
	public static void main(String[] args) {
		UserProxy userProxy = new UserProxy(new User());
		userProxy.show();
	}
}
