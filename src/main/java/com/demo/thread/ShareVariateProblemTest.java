package com.demo.thread;

public class ShareVariateProblemTest {
	//Thread-X===0即出现问题了
	//加锁比不加锁几乎慢了一倍
	//守护线程问题？？
	public static void main(String[] args) {
		System.out.println("当前线程：" + Thread.currentThread().getName());
		System.out.println("内核数：" + Runtime.getRuntime().availableProcessors());
		System.out.println("双线程加锁：" + (1533710715818L - 1533710705818L));
		System.out.println("双线程不加锁：" + (1533710821482L -1533710816475L));
		System.out.println("四线程加锁：" + (1533711422191L -1533711412156L));
		System.out.println("四线程不加锁：" + (1533711178385L -1533711175242L));
		System.out.println("八线程不加锁：" + (1533711608502L - 1533711607198L));
		
		VariateThread t=new VariateThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		
	}
}
