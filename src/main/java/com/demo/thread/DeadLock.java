package com.demo.thread;


public class DeadLock implements  Runnable {
	
    /**
     * 死锁分析，从运行日志可以看出，程序即无法向下执行，也不会抛出任何异常，就这样一直僵持着。究其原因，是因为：
     * 上面的程序中A对象和B对象的方法都是同步方法，也就是说A对象和B对象都是同步锁。程序中的两个线程执行，一个线程的线程执行体是DeadLock的run方法，
     * 另一个线程的执行体是DeadLock的init方法（主线程调用了init()方法）。其中run()方法中让B对象调用bar()方法，而init()方法让A对象调用foo()方法。
     * 从输出可以看出init方法先执行，调用了A对象的foo方法，进入foo()方法之前，该线程对A对象进行加锁，—–当程序执行到①号代码时，主线程暂停200ms: CPU切换到执行另一个线程，
     * 让B对象执行bar()方法，所以看到子线程开始执行B实例的bar方法，进入bar方法之前，该线程对B对象加锁—–当程序执行到②号代码的时候，子线程也暂停200ms；接下来主线会先醒过来，
     * 继续向下执行，直到③号代码处希望调用B对象的last方法—-执行前必须对B对象进行加锁，但此时子线程正保持着对B对象的锁，所以主线程阻塞；接下来子线程也醒过来了，继续向下执行，
     * 直到④号代码处希望调用A对象的last()方法—–执行该方法之前必须对A对象进行加锁，但此时主线程没有释放A对象的锁。 到这里就出现主线程保持A对象的锁，等待对B对象加锁，
     * 而子线程保持着B对象的锁，等待对A对象加锁，两个线程互相等待对方先释放，所以就出现了死锁。
     */
    public static void main(String args[]) throws Exception {
       DeadLock dl=new DeadLock();
       new Thread(dl).start();//子线程
       dl.init();//主线程
    }

    class A{
        public synchronized void foo(B b){

          System.out.println(Thread.currentThread().getName()+"： 进入了A实例的foo方法");//①

          try {
        	  System.out.println(Thread.currentThread().getName()+"： 开始睡眠");
        	  Thread.sleep(200);
          }catch (InterruptedException e){
            e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName()+"： 企图调用B实例的last方法");//③
          b.last();
        }

        public synchronized void last(){
            System.out.println("进入了A实例的last方法");
        }
    }

    class B{
      public synchronized void bar(A a){
          System.out.println(Thread.currentThread().getName()+"： 进入了B实例的bar方法");//②

          try {
        	  System.out.println(Thread.currentThread().getName()+"： 开始睡眠");
              Thread.sleep(200);
          }catch (InterruptedException e){
              e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName()+"： 企图调用A实例的last方法");//④
          a.last();
      }

      public synchronized void last(){
          System.out.println("进入了B实例的last方法");
      }
    }

    A a=new A();
    B b=new B();

    public void init(){
      Thread.currentThread().setName("主线程");
       a.foo(b);
      System.out.println("进入了主线程之后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("子线程");
        b.bar(a);
        System.out.println("进入了子线程之后");
    }


}
