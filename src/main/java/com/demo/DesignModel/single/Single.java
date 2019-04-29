package com.demo.DesignModel.single;

public class Single {

	//懒汉模式
    private static volatile Single instance = null;  
    private Single(){}
    public static Single getInstance() {
        if (instance == null) {  //双重校验锁
            synchronized (Single.class) {  
                if (instance == null) { //双重校验锁 
                    instance = new Single();  
                }  
            }  
        }  
        return instance;  
    }
    
    //synchronized修饰的同步方法比一般方法要慢很多，通过双重校验锁解决。
    //volatile的一个语义是禁止指令重排序优化，也就保证了instance变量被赋值的时候对象已经是初始化过的，从而避免了取到状态不正确的对象
}

//饿汉模式
//缺点：类比较大的话在加载时就创建实例会比较占用内存
class Singleton{  
	   private static Singleton instance = new Singleton(); //类加载时就创建这个实例  
	   private Singleton(){}  
	   public static Singleton newInstance(){  
	        return instance;  
	    }  
} 