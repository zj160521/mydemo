package com.demo.DesignModel.proxy.JDK;

public class JDKProxyTest {
	
//	JDK动态代理有以下特点:
//	1.代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
//	2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
//	3.动态代理也叫做:JDK代理,接口代理
//
//	JDK中生成代理对象的API
//	代理类所在包:java.lang.reflect.Proxy
//	JDK实现代理只需要使用newProxyInstance方法,但是该方法需要接收三个参数,完整的写法是:
//
//	static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
//	注意该方法是在Proxy类中是静态方法,且接收的三个参数依次为:
//
//	ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
//	Class<?>[] interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
//	InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
	public static void main(String[] args) {
		IUser user = new User();
		IUser proxyInstance = (IUser) new ProxyFactory(user).getProxyInstance();
		proxyInstance.show();
		
	}
}
