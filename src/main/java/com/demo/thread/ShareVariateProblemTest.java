package com.demo.thread;

public class ShareVariateProblemTest {
	// 共享变量问题，当Thread-X===0即出现问题了，在t==1时，线程休眠使得其他线程也取得t==1进入了方法体中
	// 加锁比不加锁几乎慢了一倍
	public static void main(String[] args) {
		System.out.println("当前线程：" + Thread.currentThread().getName());
		System.out.println("内核数：" + Runtime.getRuntime().availableProcessors());
		System.out.println("双线程加锁：" + (1533710715818L - 1533710705818L));
		System.out.println("双线程不加锁：" + (1533710821482L -1533710816475L));
		System.out.println("四线程加锁：" + (1533711422191L -1533711412156L));
		System.out.println("四线程不加锁：" + (1533711178385L -1533711175242L));
		System.out.println("八线程不加锁：" + (1533711608502L - 1533711607198L));

		// 共同使用一个variateThread对象，共享变量t
		VariateThread variateThread = new VariateThread();
		new Thread(variateThread,"线程1").start();
		new Thread(variateThread).start();
		new Thread(variateThread).start();
		new Thread(variateThread).start();
		new Thread(variateThread).start();
		new Thread(variateThread).start();
	}
}
class VariateThread implements Runnable {
	private int t = 100;

	@Override
	public void run() {
//		synchronized (VariateThread.class) {
			while (t > 0) {
				System.out.println("sT:" + t);
				if(t == 100){
					System.out.println(System.currentTimeMillis());
				}
				if(t == 0){
					System.out.println(System.currentTimeMillis());
					break;
				}
				try {
					Thread.sleep(100);
					System.out.println("eT:" + t);
					System.out.println("当前线程：" + Thread.currentThread().getName() + "====" + t--);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//		}
	}
}
