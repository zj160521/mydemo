package com.demo.thread.Callable;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: zhouj
 * @Date: 2019/8/8 9:34
 */
public class CallableTest {
    public static void main(String[] args) {
//        FutureTask<String> futureTask = new FutureTask<>(new CallThread("非线城池"));
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            return "非线城池启动线程";
        });
        Thread my = new Thread(futureTask);
        my.start();
        try {
            System.out.println(futureTask.get(10, TimeUnit.SECONDS));
//            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        // 线程池启动线程
        // 第一个参数0:闲置时线程池中保持的线程数量
        // 第二个参数：线程池所允许的最大线程数
        // 第三个参数：闲置线程存活的最大时间，执行完一个task之后线程依然运行的时间
        // 第四个参数：闲置线程存活的最大时间的单位
        // 第五个参数：任务执行前用于保存任务的队列
        ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<>());
        // ThreadPoolExecutor 继承AbstractExecutorService，submit()在AbstractExecutorService中实现
        Future<String> future = executor.submit(new CallThread("线程池"));
        try {
            String msg = future.get();
            System.out.println(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
            future.cancel(true);
        } catch (ExecutionException e) {
            e.printStackTrace();
            future.cancel(true);
        }
    }

}

class CallThread implements Callable<String>{
    private String msg;
    public CallThread(String str){
        this.msg = str;
    }
    @Override
    public String call() throws Exception {
        return msg+"启动线程";
    }
}