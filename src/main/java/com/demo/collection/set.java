package com.demo.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class set {

	/**
	 * HashSet
	 * 
	 * 1.	extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable
	 * 
	 * 2.	public HashSet() {map = new HashMap<>();}
	 * 		map.put(e, PRESENT)==null;
	 * 		其实是由HashMap实现，map的K存值，value PRESENT是一个空对象
	 * 
	 * 3.	非线程安全
	 */
	public void analyzeHashSet(){}
	
	/**
	 * LinkedHashSet
	 * 
	 * 1.	extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable
	 * 
	 * 2.	由LinkedHashMap实现，采用指针来实现排序
	 */
	public void analyzeLinkedHashSet(){}
	
	/**
	 * TreeSet
	 * 
	 * 1.由TreeMap实现，key存值
	 */
	public void analyzaTreeSet(){}
	
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("ok");
		
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("ok");
		
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("56");
	}
}
