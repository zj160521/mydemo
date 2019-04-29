package com.demo.extend;

public class father {

	protected static String s="hello";
	
	public father() {}


	protected static String showWord(){
		System.out.println(s);
		show();
		return "world";
	}
	
	public static void show(){
		System.out.println("father");
	}
}
