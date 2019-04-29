package com.demo.factorymethodandthreadpool;

public class BMW5x extends BMW implements Runnable{

	public void makeBMW(){
		System.out.println("5xi");
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" :5xi");
	}
}
