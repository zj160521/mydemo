package com.demo.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	
	@SuppressWarnings("resources")
	public static void main(String[] args) {
		// 获取上下文
		ApplicationContext context =
				new ClassPathXmlApplicationContext("bean3.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}
}
