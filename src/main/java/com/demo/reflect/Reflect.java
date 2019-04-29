package com.demo.reflect;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Reflect {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {
		
//		Vo vo =new Vo();
//		vo.setM1(1.2);
//		Class cla = vo.getClass();
		
		String addr = "StaticProxyTest.Vo";
		Class<?> clazz = Class.forName(addr);
		
		//clazz.newInstance(),是在调类的无参构造方法
		Object clazzObject = clazz.newInstance();
		Class objectClass = clazzObject.getClass();
		
		Method setM1 = objectClass.getDeclaredMethod("setM1", double.class);
		setM1.invoke(clazzObject, 2.4);
		
		Method getMx =objectClass.getDeclaredMethod("getM1");
		Method getMs =objectClass.getDeclaredMethod("syso",String.class);
			
		System.out.println(getMs.invoke(clazzObject,"nihao"));
		System.out.println(getMx.invoke(clazzObject));
		
		//非public的属性和方法需setAccessible(true)才能获取值或者执行
		Field[] fields = objectClass.getDeclaredFields();
		for(Field field:fields){
			field.setAccessible(true);
			System.out.println(field.getDouble(clazzObject));
		}

		//反射读取配置文件
		InputStream resourceAsStream = objectClass.getResourceAsStream("/log4j.properties");
		System.out.println(resourceAsStream);
		byte[] tempbytes = new byte[1024];
	    @SuppressWarnings("unused")
		int ch=0;
		while((ch=resourceAsStream.read(tempbytes))!=-1){
			System.out.write(tempbytes);
		}
		resourceAsStream.close();
	}
}
