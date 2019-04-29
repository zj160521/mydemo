package com.demo.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class list {
	/**
	 *1. extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
     *   public Object clone()
	 *   实现了Cloneable接口，数组可克隆
	 *   实现了Serializable接口，可序列化
	 *	
	 *2. private static final Object[] EMPTY_ELEMENTDATA = {};
	 *   private transient Object[] elementData;
	 *   底层由数组实现
	 *
	 *3. private static final int DEFAULT_CAPACITY = 10;
	 *   初始化元素长度为10
	 *
	 *4. private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	 *   数组最大长度为 2147483647-8（2的31次方-8）
	 *
	 *5. private void grow(int minCapacity) 添加容量的方法
	 *   int newCapacity = oldCapacity + (oldCapacity >> 1);
	 *   添加时检查容量，不够进行扩容，扩容容量为原容量的一半
	 *    
	 *6. 由于增加超过容量时需要扩容,插入、删除指定位置需要改变元素位置，获取元素可通过数组下标获取，因此增删慢查询快
	 *
	 *7. 相比于Vector的方法都加了synchronized（锁），ArrayList是非线程安全的集合
	 *   public synchronized E get(int index) ， public synchronized boolean add(E e)
	 */
	private void analyzeArrayListAndVector(){
		
	}
	
	/**
	 * 1. extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable
	 *    可克隆序列化
	 *    
	 * 2. Node<E>
	 *    有next和prev两个指针，双向链表结构实现
	 *    
	 * 3. public E get(int index),add,delete等涉及index下标的都通过Node<E> node(int index)方法实现
	 *    Node<E> node(int index)中查询元素算法采用的是二分查找算法
	 * 
	 * 4. 非线程安全
	 */
	private void analyzeLinkedList(){
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.remove(1);
		@SuppressWarnings("unchecked")
		ArrayList<Integer> clone = (ArrayList<Integer>) al.clone();
		for(Integer i : clone){
			System.out.println(i);
		}
		
		
		Vector<Integer> vl = new Vector<Integer>();
		vl.add(1);
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(2);
		ll.clone();
		ll.get(0);
		
		System.out.println(false ^ false);
	}
}


