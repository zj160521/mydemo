package com.demo.thread;

public class VariateThread implements Runnable {
	private int t = 100;
	
	@Override
	public void run() {
		while (true) {
//			synchronized (thread.class) {
				if(t == 100){
					System.out.println(System.currentTimeMillis());
				}
				if(t == 0){
					System.out.println(System.currentTimeMillis());
					break;
				}
				if (t > 0) {
					try {
						Thread.sleep(100);
						System.out.println("当前线程：" + Thread.currentThread().getName() + "====" + t--);
//						System.out.println("T:" + t);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
//			}
		}
	}
}