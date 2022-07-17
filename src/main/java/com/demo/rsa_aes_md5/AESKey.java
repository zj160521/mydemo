package com.demo.rsa_aes_md5;

import java.util.Random;

public class AESKey {
    /**
     * 获取一个指定位数的随机数
     *
     * @param length 随机数长度
     * @return
     */
    public static String getRandomString(int length) {
        // 定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        // 由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        // 长度为几就循环几次
        for (int i = 0; i < length; ++i) {
            // 产生0-61的数字
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
