package com.demo.designModel.proxy.Cglib;

public class CglibProxyTest {

    /**
     * cglib是针对类来实现代理的，原理是对指定的业务类生成一个子类，并覆盖其中业务方法实现代理。
     * 因为采用的是继承，所以不能对final修饰的类进行代理。
     * @param args
     */
	public static void main(String[] args) {
		 //目标对象
        User target = new User();

        //代理对象
        User proxy = (User)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.show();
		
	}
}
