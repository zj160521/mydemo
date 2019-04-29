package com.demo.DesignModel.proxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	private Object object;
	
	public ProxyFactory(Object object) {
		this.object = object;
	}



	public Object getProxyInstance(){
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), 
				object.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("start1");
						//test中代用的是show方法，在这可以通过反射来指定调用哪个
						method = object.getClass().getDeclaredMethod("time");
						System.out.println("所要执行的方法："+method);
						Object returnValue = method.invoke(object);
						System.out.println("方法执行的返回值："+returnValue);
						return null;
					}
				});
	}
}
