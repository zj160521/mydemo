package com.demo.designModel.proxy.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor{
	//目标对象
	private Object target;
	
	public ProxyFactory(Object target) {
		this.target = target;
	}

	//给目标对象创建一个代理对象
    public Object getProxyInstance(){
    	//1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();

    }
	@Override
	public Object intercept(Object obj, Method method, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("开始事务...");

        //执行目标对象的方法
        Object returnValue = method.invoke(target, arg2);

        System.out.println("提交事务...");

        return returnValue;
	}
}
