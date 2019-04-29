package com.demo.collection;

import java.util.Date;


public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date t1=new Date();
		String s= "happy";
		String s2= "happiness";
		System.out.println(s.compareTo(s2));

		System.out.println((int)(Math.random()*10));
		Date t2=new Date();

		System.out.println(t2.getTime()-t1.getTime());
	}

}
