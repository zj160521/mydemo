package com.demo.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class map {
	/**
	 * HashMap
	 * 
	 * 1. 	extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable
	 * 		克隆，序列化
	 *    
	 * 2.	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
	 * 		static final int MAXIMUM_CAPACITY = 1 << 30;
	 * 		初始化16个元素容量，最大2的30次方个元素
	 * 
	 * 3.	transient Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;
	 * 		static class Entry<K,V> implements Map.Entry<K,V> { Entry<K,V> next;
	 * 		底层是Entry<K,V>类对象数组，含有后指针，说明数组中元素有单向链表结构，也正是解决hash值冲突的方法
	 * 
	 * 4.	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	 * 		
	 * 5.	n & hash == hash % n;
	 * 		int i = indexFor(hash, table.length);
	 * 		static int indexFor(int h, int length) {return h & (length-1);}
	 * 		下标值由hash值与table长度取模得到
	 * 
	 * 6.	非线程安全
	 */
	public void analyzeHashMap(){}
	
	/**
	 * Hashtable
	 * 
	 * 1.	private transient Entry<K,V>[] table;
	 * 		Entry<K,V> next;
	 * 		entry对象数组结构,单向链表处理hash冲突
	 * 
	 * 2.	public synchronized V put(K key, V value)
	 * 		调用方法加了synchronized字段，一个线程安全的map
	 */
	public void analyzeHashtable(){}
	
	/**
	 * LinkedHashMap
	 * 
	 * 1.	private transient Entry<K,V> header;
	 * 		Entry<K,V> before, after;
	 * 		entry对象双向链表结构实现排序
	 * 
	 * 2.	extends HashMap<K,V> implements Map<K,V>
	 * 
	 * 3.	非线程安全
	 */
	public void analyzeLinkedHashMap(){}
	
	/**
	 * 
	 */
	public void analyzeTreeMap(){}
	
	
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("1", "ok");
		hm.keySet();
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("1", "ok");
		
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
		lhm.put("1", "ok");
		
		TreeMap<String, String> tm = new TreeMap<String, String>();
		tm.put("1", "ok");
		
		System.out.println(0x7FFFFFFF);
	}
}
