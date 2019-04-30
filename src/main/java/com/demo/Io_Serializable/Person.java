package com.demo.Io_Serializable;

import java.io.Serializable;

public class Person implements Serializable{
	
	/**
	 * serialVersionUID 相当于一个摘要算法得到的值，在序列化和反序列化时验证此值表明为同一对象
	 */
	private static final long serialVersionUID = 1881041448864195313L;
	private String name;
	private int age;
	private transient String sex;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
