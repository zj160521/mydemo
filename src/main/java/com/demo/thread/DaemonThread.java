package com.demo.thread;

/**
 *  守护线程在所有用户线程运行完毕之后就会停止运行
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException{
        new Thread(()->{
            for (int i = 1; i < 10; i++) {
                System.out.println(i);
            }
        }).start();
        Thread daemonThread = new Thread(()->{
            synchronized (DaemonThread.class){

            }
            int i = 1;
            while (true){
                System.out.println("daemon: "+ i++);
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        Thread.sleep(1000000);
    }
}
