package com.demo.rsa_aes_md5;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

/**
 * @author zhouj
 */
public class RSA {
    private static String PADDING = "RSA/NONE/NoPadding";
    private static String PROVIDER = "BC";

    //rsa加密
    public static byte[] encrypt(String text, PublicKey key) {
        byte[] cipherText = null;
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            final Cipher cipher = Cipher.getInstance(PADDING, PROVIDER);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cipherText;
    }

    //rsa解密
    public static String decrypt(byte[] text, PrivateKey key) {
        byte[] dectyptedText = null;
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            final Cipher cipher = Cipher.getInstance(PADDING, PROVIDER);
            cipher.init(Cipher.DECRYPT_MODE, key);
            dectyptedText = cipher.doFinal(text);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new String(dectyptedText);
    }
}
