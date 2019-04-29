package com.demo.collection;

import java.util.Arrays;

public class StringSort {

	public static void main(String[] args) {
		//字符串排序
		String[] a={"你","ac","bc"};
		Arrays.sort(a);
		for(String s : a){
			System.out.println("==="+s);
			s.hashCode();
		}
		
		//字符串内部排序
		String ss="654321fedsa";
		//第一种方法，将字符串转化成char数组，用Arrays.sort()排序
		char[] c=ss.toCharArray();
		Arrays.sort(c);
//		String res = String.valueOf(c);
		
		//第二种，char可以直接比较大小
		System.out.println(sort(ss));
	}
	    public static String sort(String str){
	    	char[] charArray = str.toCharArray();
	    	boolean flag;
	    	int len =  charArray.length;
	    	char temp;
	    	do{
	    		flag = false;
	    		for(int i = 1;i < len; i++){
	    			if(charArray[i-1] > charArray[i]){
	    				temp = charArray[i-1];
	    				charArray[i-1] = charArray[i];
	    				charArray[i] = temp;
	    				flag = true;
	    			}
	    		}
	    		len --;
	    	}while(flag);
	    	
	    	String st = new String(charArray);
	    	
	        return st;
	    }
	    
	    
}
