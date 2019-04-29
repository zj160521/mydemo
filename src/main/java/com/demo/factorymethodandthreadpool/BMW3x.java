package com.demo.factorymethodandthreadpool;

public class BMW3x extends BMW implements Runnable{

	public void makeBMW(){
		System.out.println("3xi");
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" :3xi");
	}
}
