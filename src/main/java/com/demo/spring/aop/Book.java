package com.demo.spring.aop;

public class Book {
	private String bookName;
	public Book() {}
	public Book(String name) {
		this.bookName = name;
	}

	public void add() {
		System.out.println("add..........." + bookName);
	}
}
