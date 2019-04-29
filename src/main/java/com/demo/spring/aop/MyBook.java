package com.demo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {

	public void before1() {
		System.out.println("before......");
	}
	
	public void after1() {
		System.out.println("after......");
	}
	
	//环绕通知
	public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		//方法之前
		System.out.println("sbefore.....");
		
		//执行被增强的方法
		proceedingJoinPoint.proceed();
		
		//方法之后
		System.out.println("safter.....");
	}
}
