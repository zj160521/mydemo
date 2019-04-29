package com.demo.readproperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		
		InputStream inStream = new FileInputStream(new File("D:\\etc\\mineserver.cfg"));
		
		Properties prop = new Properties();  
		prop.load(inStream);  
		String key = prop.getProperty("redis.port");
		System.out.println(key);
	}

}
