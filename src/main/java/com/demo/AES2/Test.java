package com.demo.AES2;

import javax.crypto.Cipher;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Random;

public class Test {
	
	private String pri_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKo++i9J9dzAFtbxwowKDCo2mxi7MXxE8A8VvssaydWjjgmEz/HHMPLOhi1182a1si4pWL0/MizKnquD7T2Bu4jpQ"
			+ "bAFnkNYEMEyq/kw904Xl0JCQHYFuvnI99RE8Q3KlTP6kEUGDjV34EL6vBGJcQvArLtj1xoP8y0nIfJ2Pw5TAgMBAAECgYAGGB8IllMwxceLhjf6n1l0IWRH7FuHIUieoZ6k0p6rASHSgWiYNR"
			+ "MxfecbtX8zDAoG0QAWNi7rn40ygpR5gS1fWDAKhmnhKgQIT6wW0VmD4hraaeyP78iy8BLhlvblri2nCPIhDH5+l96v7D47ZZi3ZSOzcj89s1eS/k7/N4peEQJBAPEtGGJY+lBoCxQMhGyzuzDm"
			+ "gcS1Un1ZE2pt+XNCVl2b+T8fxWJH3tRRR8wOY5uvtPiK1HM/IjT0T5qwQeH8Yk0CQQC0tcv3d/bDb7bOe9QzUFDQkUSpTdPWAgMX2OVPxjdq3Sls9oA5+fGNYEy0OgyqTjde0b4iRzlD1O0OhLq"
			+ "PSUMfAkEAh5FIvqezdRU2/PsYSR4yoAdCdLdT+h/jGRVefhqQ/6eYUJJkWp15tTFHQX3pIe9/s6IeT/XyHYAjaxmevxAmlQJBAKSdhvQjf9KAjZKDEsa7vyJ/coCXuQUWSCMNHbcR5aGfXgE4e4"
			+ "5UtUoIE1eKGcd6AM6LWhx3rR6xdFDpb9je8BkCQB0SpevGfOQkMk5i8xkEt9eeYP0fi8nv6eOUcK96EXbzs4jV2SAoQJ9oJegPtPROHbhIvVUmNQTbuP10Yjg59+8=";
	
	private String pub_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqPvovSfXcwBbW8cKMCgwqNpsYuzF8RPAPFb7LGsnVo44JhM/xxzDyzoYtdfNmtbIuKVi9PzIsyp6rg+09gbuI"
			+ "6UGwBZ5DWBDBMqv5MPdOF5dCQkB2Bbr5yPfURPENypUz+pBFBg41d+BC+rwRiXELwKy7Y9caD/MtJyHydj8OUwIDAQAB";

	public static void main(String[] args) throws IOException {
//		StringBuffer orgFile = new StringBuffer();
//		orgFile.append("D:/Rsa/download/tmp/1.txt");
//		String encryptFile = "D:/Rsa/download/tmp/密文.txt";
//		String orgFile2 = "D:/Rsa/download/tmp/明文.txt";
//		
//		try {
//			int length1 = AES.encrypt(orgFile,encryptFile,"1234567890123456",4,4);
//			System.out.println("密文长度："+length1);
//			int length2 = AES.decrypt("D:/RealtimeData/KJ65N _SSSJ_20180529144200.txt","D:/Rsa/download/tmp/明文12.txt","KoQY7jDOX4IxpGem",4,4);
//			System.out.println("明文长度："+length2);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		String AESKey = getRandomString(16);
		System.out.println(AESKey);
		
	}
	
	public static String getRandomString(int length){
	    //定义一个字符串（A-Z，a-z，0-9）即62位；
		String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		//由Random生成随机数
	    Random random=new Random();
	    StringBuffer sb=new StringBuffer();
	    //长度为几就循环几次
	    for(int i=0; i<length; ++i){
	      //产生0-61的数字
	      int number=random.nextInt(62);
	      //将产生的数字通过length次承载到sb中
	      sb.append(str.charAt(number));
	    }
	    //将承载的字符转换成字符串
        return sb.toString();
	}
	
	@SuppressWarnings("unused")
	private static String decrypt(byte[] srcFile, PrivateKey privateKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] bt_original = cipher.doFinal(srcFile);
		
		return new String(bt_original);
	}
}
