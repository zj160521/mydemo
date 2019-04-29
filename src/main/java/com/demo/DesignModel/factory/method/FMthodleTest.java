package com.demo.DesignModel.factory.method;

import java.lang.reflect.Method;

//����ģʽ���ڸ������ѡ����Ҫ�����Ķ��󣬴����Ķ�������ǲ�ͬ���͵���,������pojo,Ҳ�����Ǹ��ӵ������һ�㲻��ֵ
//����ڽ�����ģʽ���ڴ���ͬһ���͵ļ�Javabeans,�����и�ֵ

public class FMthodleTest {

	public static void main(String[] args) throws Exception {

		String bmw3x="com.BMW3xFactory";
//		Class clazz =Class.forName(bmw3x);
		Class<?> f= Class.forName(bmw3x);
		Method bmw = f.getDeclaredMethod("make");
		BMW b=(BMW) bmw.invoke(f.newInstance());
		b.makeBMW();
	}


}
