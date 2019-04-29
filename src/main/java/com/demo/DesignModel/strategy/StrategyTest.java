package com.demo.DesignModel.strategy;


public class StrategyTest {

	// 1.什么是策略模式？
	// 针对一组算法，当客户端做出选择时才知道用哪种的时候而采用的一种模式，例如：清单平台系统中按省、市、区哪种方式运算
	// 2实现：1）这组算法类统一实现策略接口，算法都在重写的方法中实现
	//		  2）定义一个context类也实现接口，有参构造以策略接口作为参数，重写方法，进行选择
	public static void main(String[] args) throws Exception {

		double d = 10;
		String s ="com.test.DesignModel.strategy.GoldGuest";
		
		Class<?> clazz = Class.forName(s);
		StrategyInterface si= (StrategyInterface) clazz.newInstance();
		
		PriceContext pc = new PriceContext(si);
		System.out.println(pc.calculate(d));
	}

}
