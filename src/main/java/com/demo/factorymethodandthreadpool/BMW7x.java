package com.demo.factorymethodandthreadpool;

public class BMW7x extends BMW implements Runnable{

	public void makeBMW(){
//		System.out.println("7xi");
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" :7xi");
		
	}
}
