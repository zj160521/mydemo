package com.demo.rsa_aes_md5;

import java.util.HashMap;

/**
 * AES对称加密数据相较于RSA加密速度较快，所以采用AES加密数据内容，再利用rsa非对称加密对AES的密钥进行加密，MD5验证加密前后数据是否被篡改
 * RSA客户端将公钥发给服务端，服务端加密，然后将数据传送给客户端，客户端自己用自己的私钥进行解密
 *
 * @author zhouj
 */
public class Test {

    //公钥
    private static String pub_key
//			= "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqPvovSfXcwBbW8cKMCgwqNpsYuzF8RPAPFb7LGs"
//			+ "nVo44JhM/xxzDyzoYtdfNmtbIuKVi9PzIsyp6rg+09gbuI6UGwBZ5DWBDBMqv5MPdOF5dCQkB2Bbr5yPfURPENypUz+pB"
//			+ "FBg41d+BC+rwRiXELwKy7Y9caD/MtJyHydj8OUwIDAQAB";

            = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzjnOi0Tc0OX8rz7KiA7eCc1Dj"
            + "ZndXBT2bQaf14j2BKFquzI1qhyJmjw/b9jDcVoiSAgOzTbxvgEBGXUBECp7aOJOS"
            + "IN7fkzRNcIFBN5qzIVyfAkMj8gxkGzSai6rE4yrTIWQdCu6WVd4Rd39WuxRetwWD"
            + "OYLCRPadQXCze+XnbQIDAQAB";
    //私钥
    private static String pri_key
//			= "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKo++i9J9dzAFtbxwowKDCo2mxi7MX"
//			+ "xE8A8VvssaydWjjgmEz/HHMPLOhi1182a1si4pWL0/MizKnquD7T2Bu4jpQbAFnkNYEMEyq/kw904Xl0JCQHYFuvnI99R"
//			+ "E8Q3KlTP6kEUGDjV34EL6vBGJcQvArLtj1xoP8y0nIfJ2Pw5TAgMBAAECgYAGGB8IllMwxceLhjf6n1l0IWRH7FuHIUie"
//			+ "oZ6k0p6rASHSgWiYNRMxfecbtX8zDAoG0QAWNi7rn40ygpR5gS1fWDAKhmnhKgQIT6wW0VmD4hraaeyP78iy8BLhlvblr"
//			+ "i2nCPIhDH5+l96v7D47ZZi3ZSOzcj89s1eS/k7/N4peEQJBAPEtGGJY+lBoCxQMhGyzuzDmgcS1Un1ZE2pt+XNCVl2b+T"
//			+ "8fxWJH3tRRR8wOY5uvtPiK1HM/IjT0T5qwQeH8Yk0CQQC0tcv3d/bDb7bOe9QzUFDQkUSpTdPWAgMX2OVPxjdq3Sls9oA"
//			+ "5+fGNYEy0OgyqTjde0b4iRzlD1O0OhLqPSUMfAkEAh5FIvqezdRU2/PsYSR4yoAdCdLdT+h/jGRVefhqQ/6eYUJJkWp15"
//			+ "tTFHQX3pIe9/s6IeT/XyHYAjaxmevxAmlQJBAKSdhvQjf9KAjZKDEsa7vyJ/coCXuQUWSCMNHbcR5aGfXgE4e45UtUoIE"
//			+ "1eKGcd6AM6LWhx3rR6xdFDpb9je8BkCQB0SpevGfOQkMk5i8xkEt9eeYP0fi8nv6eOUcK96EXbzs4jV2SAoQJ9oJegPtP"
//			+ "ROHbhIvVUmNQTbuP10Yjg59+8=";

            = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALOOc6LRNzQ5fyvP"
            + "sqIDt4JzUONmd1cFPZtBp/XiPYEoWq7MjWqHImaPD9v2MNxWiJICA7NNvG+AQEZd"
            + "QEQKnto4k5Ig3t+TNE1wgUE3mrMhXJ8CQyPyDGQbNJqLqsTjKtMhZB0K7pZV3hF3"
            + "f1a7FF63BYM5gsJE9p1BcLN75edtAgMBAAECgYA+M3ftjEpyZgSe+blpFJ6Kq0X3"
            + "MLTgyWj5ErqLnE8wIfmgGi5XG+8X1jFpQpTUj4mKAvajM6e2fJhHh+BOcdtrKmDn"
            + "CBO80NZDNLyuKumemCyPqPYqmSXTiOa7nu3C9HlhL/adK0t6brHbCH6wgR1ANP3T"
            + "F71wdjGfMKWS+X9C5QJBAOQFfkDIPOUUlWpuVs3mRBkZmDDT9JOV9b3EItuWWviw"
            + "rLJca2pJGcM/0m32uePei079C+WM2ltNYLNrYnlvWfMCQQDJlpkDBjI6n1z4PU2r"
            + "UpAvqJeBor57If/rUqAPUvxd08mGynmHvdtyiNjtwKp23tmd4xirpfqillVkkpwK"
            + "I7EfAkEAkYKn5PNjWNTf3MF5B4AwaMwagN5hr2T9IxJtJDA48YbdTh0INxVbKWwq"
            + "/x151t6Hi+qTkvNlzOn+EcEvYEsc3QJABnjHQMmaIzeqjG2raKyl5GHNO2Q2KU3W"
            + "IX/tk5BeecSq26D0dd8qhGrQTBG7Z0WQRvlbeWdCvKWG6EuspsaukQJAJ2ORDKwO"
            + "znccpmD2knEwJazByQRC8KFKA51JCFcfUScciN9S7hjgEnoZtU5DuhWfVV61Ul+r"
            + "gEr/y5wKC8y6Aw==";

    public static void main(String[] args) {
        HashMap<String, String> map = Encrypt.encryptData("D:/aaa/en.txt", "D:/aaa/un.txt", new StringBuffer("没查到划分空间啊水电费看看大是大是东方红非"), pub_key);
        String decryptData = Decrypt.decryptData(map.get("rsaEncrypt"), "D:/aaa/en.txt", "D:/aaa/de.txt", pri_key);
        System.out.println("加密密钥密文== " + map.get("rsaEncrypt"));
        System.out.println("解密数据明文== " + decryptData);
        if (map.get("md5Encrypt").equals(MD5.MD5Encrypt(decryptData.trim())))
            System.out.println(map.get("md5Encrypt") + "=====" + MD5.MD5Encrypt(decryptData.trim()));
    }
}
