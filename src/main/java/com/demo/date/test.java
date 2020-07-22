package com.demo.date;

import java.text.ParseException;

public class test {

	public static void main(String[] args) throws ParseException {
		String s = "2018-05-17 00:01:01";
		String s2 = "2018-05-18 00:00:02";
		
		LongStringVo sec = StaticUtilMethod.longToTimeFormat(s, s2);
		System.out.println(sec.getTimCast());
	}
}


