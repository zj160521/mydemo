package com.demo.RSAAESMD5;

import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;

/**
 * 
 * @author zhouj
 *
 */
public class Decrypt {
	/**
	 * 
	 * @param encryptKey 密钥密文
	 * @param encryptFilePath 需解密文件路径
	 * @param decryptFilePath 解密后文件路径
	 * @param pri_key rsa密钥
	 * @return 解密后明文字符串
	 */
	public static String decryptData(String encryptKey,String encryptFilePath,String decryptFilePath,String pri_key) {
		try {
			Base64 base64 = new Base64();
			byte[] cipherTextArray = base64.decode(encryptKey);
			String AESKey = RSA.decrypt(cipherTextArray, RSAKey.getPrivateKey(pri_key));
			FileInputStream fis = new FileInputStream(encryptFilePath);
			String decrypt = AES.decrypt(fis, decryptFilePath, AESKey, 4);
			return decrypt;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}  
