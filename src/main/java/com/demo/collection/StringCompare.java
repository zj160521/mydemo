package com.demo.collection;


public class StringCompare {

	public static void main(String[] args) {
		//字符是否对称
		String str = "abcdcbad";
		char[] charArray = str.toCharArray();
		boolean flag = true;
		for(int i=0;i < charArray.length/2+1;i++){
			if(charArray[i] != charArray[charArray.length-1-i])
				flag = false;
		}
		System.out.println(flag);
	}
}
