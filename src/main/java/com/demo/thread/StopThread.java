package com.demo.thread;

/**
 *  线程停止一般针对于需要长时间运行的线程
 *  线程的停止不要采用已过时的方法，采用标志flag来标识线程是否可以运行，写法如下：
 */
public class StopThread {
    static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            int i = 1;
            while(flag){
                System.out.println("====   " + i++);
            }
        }).start();
        Thread.sleep(1);
        flag = false;
    }
}
