package com.demo.DesignModel.decorator;

public class DecoratorTest {

	// 1.什么是装饰模式？通过装饰器动态的给类添加功能而不改变初始类原有的功能
	// 添加的功能可以灵活的自由组合（与代理模式相比，代理模式缺少功能的灵活组合）
	// 2.装饰者模式与代理模式的区别？
	// 二者最主要的区别是：代理模式中，代理类对被代理的对象有控制权，决定其执行或者不执行。而装饰模式中，装饰类对代理对象没有控制权，只能为其增加一层装饰，以加强被装饰对象的功能，仅此而已。
	// 3.实现：1）首先定义装饰器Decorator，继承目标类，新建以目标类为参数的构造方法
	//		   2）其次重写目标类需要增强的方法
	//		   3）增强类继承Decorator，重写增强方法
	//		   4）增强类自由组合，增强目标类
	public static void main(String[] args) {
		Person p =new Person();
		Person hands = new Hands(p);
		Person feet = new Feet(hands);
		feet.personFunction();

		// 父类可以当做子类看
		Person p2 = new Hands(new Feet(new Person()));
		p2.personFunction();

		Person p3 = new Feet(new Hands(new Person()));
		p3.personFunction();
	}
}
