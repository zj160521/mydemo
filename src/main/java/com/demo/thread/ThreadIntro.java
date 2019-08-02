package com.demo.thread;


import java.util.concurrent.Callable;

/**
 * @Description:
 *              1.线程有3种方式实现extends Thread、implements Runable、implements Callable
 * @Author: zhouj
 * @Date: 2019/8/1 15:01
 */
public class ThreadIntro {
    public static void main(String[] args) {
        new ThreadDemo().start();
        new Thread(new ThreadDemo()).start(); // Thread1实现了Runnable，也可以传入Thread的构造方法
        new Thread(() -> System.out.println("runnable method")).start();
        System.out.println("----------多线程竞争同一资源----------");
        RunnableThread rt = new RunnableThread();
        new Thread(rt).start();
        new Thread(rt).start();
        new Thread(rt).start();

    }
}

class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("thread method");
    }
}

class RunnableThread implements Runnable {
    private int ticket = 1000;
    @Override
    public void run() {
        while (ticket >0 )
            System.out.println( Thread.currentThread().getName() +" ticket remain:" + ticket -- );
    }
}

class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}