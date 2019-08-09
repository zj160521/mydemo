package com.demo.thread;

/**
 * @Description:
 * 1.线程有3种方式实现extends Thread、implements Runable、implements Callable
 * 2.sleep（休眠）和 join（强制执行）状态都可以被interrupt中断
 * @Author: zhouj
 * @Date: 2019/8/1 15:01
 */
public class ThreadIntro {
    public static void main(String[] args) {
        Thread myThread = new ThreadDemo();
        myThread.start();
//        myThread.setPriority(Thread.MAX_PRIORITY);
//        try {
//            myThread.join(); // 强制myThread执行完再执行主线程
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if (!myThread.isInterrupted())
//          myThread.interrupt(); // 强制打断休眠
//        new Thread(new ThreadDemo(), "线程1").start();
        new Thread(() -> System.out.println("runnable method")).start();
        myThread.interrupt();


    }
}

class ThreadDemo extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0 ; i < 100 ; i++) {
//                try {
                    System.out.println(Thread.currentThread().isInterrupted());
                    if (Thread.currentThread().isInterrupted())
                        System.out.println("线程中断 todo");
                    System.out.println("num = " + i);
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    System.out.println("线程被中断");
//                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}