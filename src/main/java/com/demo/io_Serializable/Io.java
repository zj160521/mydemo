package com.demo.io_Serializable;

import java.io.*;

public class Io {

	public static void main(String[] args) throws Exception {
		//创建D盘下的io2文件夹
//		File f = new File("D:\\","io");
//		if(!f.exists()){
//			f.mkdir();
//		}

		String t="你好，i am jie!\r\n";
		//创建文件
		File file = new File("E:/Person.txt");
		if(!file.exists()){
			file.createNewFile();
		}

		//写文件
		OutputStream os = new FileOutputStream(file);
		String s = "嗨"+ 2.11 + "\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(t);
		sb.append(s);
		os.write(sb.toString().getBytes());
		os.write(t.getBytes());
		os.close();
		
		//读文件
		StringBuffer str = new StringBuffer();
		InputStream is = new FileInputStream(file);
		byte[] tempbytes = new byte[1024];
		int ch=0;/*偏移量*/
		while((ch = is.read(tempbytes)) != -1){
			System.out.println("ch = " + ch);
			str = str.append(new String(tempbytes,0,ch,"UTF-8"));
		}
		System.out.println("final = " + ch);
		is.close();
		System.out.println(str);
	}

}
