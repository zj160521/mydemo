package com.demo.rsa_aes_md5;

import org.apache.commons.codec.binary.Base64;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;


public class Encrypt {

    /**
     * 加密数据
     *
     * @param encryptFile   加密数据文件
     * @param unencryptFile 明文文件
     * @param data          需加密数据
     * @param pub_key       rsa公钥
     */
    public static HashMap<String, String> encryptData(String encryptFile, String unencryptFile, StringBuffer data, String pub_key) {
        try {
            // 获取元数据MD5摘要
            String md5Encrypt = MD5.MD5Encrypt(data.toString());
            // 获取aesKey
            String aesKey = AESKey.getRandomString(16);
            // 加密数据并写到指定文件
            AES.encrypt(data, encryptFile, aesKey, 4);
            // 明文写到指定文件
            OutputStream os = new FileOutputStream(unencryptFile);
            os.write(data.toString().getBytes());
            os.close();
            // 加密AES密钥
            String rsaEncrypt = RsaEncrypt(aesKey, pub_key);

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("rsaEncrypt", rsaEncrypt);
            map.put("md5Encrypt", md5Encrypt);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param data   需加密数据
     * @param pubKey 公钥字符串
     * @return
     */
    public static String RsaEncrypt(String data, String pubKey) {
        try {
            //加密aes的key
            byte[] AESKeyEncrypt = RSA.encrypt(data, RSAKey.getPublicKey(pubKey));
            //返回密文字符串
            Base64 base64 = new Base64();
            String cipherTextBase64 = base64.encodeToString(AESKeyEncrypt);
            return cipherTextBase64;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}  
