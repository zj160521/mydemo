package com.demo.io_Serializable;

import java.io.*;

public class GetCharSet {
	@SuppressWarnings("resources")
	public static String get_charset(File file) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];//首先3个字节
        try {
            boolean checked = false;
            ;
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(file));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1)
                return charset;
            if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE
                    && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF
                    && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8";
                checked = true;
            }
            bis.reset();
            if (!checked) {
                // int len = 0;
                int loc = 0;
 
                while ((read = bis.read()) != -1) {
                    loc++;
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)
                            // (0x80
                            // - 0xBF),也可能在GB编码内
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
 
            }
 
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return charset;
    }

	

	@SuppressWarnings("resources")
	public static void main(String[] args) {
        try {
            File dir = new File("d:\\1.txt");//指定路径
            String charset=get_charset(dir);
            BufferedReader br = null;
            if (charset == "GBK") {
                InputStreamReader reader = new InputStreamReader(
                        new FileInputStream(new File("d:\\1.txt")), "gb2312");
                br = new BufferedReader(reader);
            }
            if (charset == "UTF-8") {
                br = new BufferedReader(new InputStreamReader(
                        new FileInputStream("d:\\1.txt"), "UTF-8"));
            }
            String s;
            while((s = br.readLine()) != null)
                System.out.println(s);
                //System.out.println(new String(s.getBytes("utf-8"),"utf-8"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
