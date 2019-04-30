package com.demo.factorymethodandthreadpool;

import java.lang.reflect.Method;


public class FMthodleTest {

	//多线程实现实例新建
	public static void main(String[] args) throws Exception {

		String bmw3x="com.demo.factorymethodandthreadpool.BMW3xFactory";
		Class<?> f= Class.forName(bmw3x);
		Method bmw = f.getDeclaredMethod("make");
		bmw.invoke(f.newInstance());

		String bmw5x="com.demo.factorymethodandthreadpool.BMW5xFactory";
		Class<?> f5= Class.forName(bmw5x);
		Method bmw5 = f5.getDeclaredMethod("make");
		bmw5.invoke(f5.newInstance());

		String bmw7x="com.demo.factorymethodandthreadpool.BMW7xFactory";
		Class<?> f7= Class.forName(bmw7x);
		Method bmw7 = f7.getDeclaredMethod("make");
		bmw7.invoke(f7.newInstance());

		Factory factory = new BMW3xFactory();
		factory.make();
	}


}
