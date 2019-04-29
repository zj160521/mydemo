package com.demo.license;

import com.demo.AES2.AESUtil;

import java.util.Date;

public class GenerateLicense {

	public static String getLicense(String cpuCode, String endTime){
		String license = cpuCode + "&" + endTime;
		String encrypt = AESUtil.encrypt(license, "963258");
		System.out.println(new Date(System.currentTimeMillis()));
		return encrypt;
	}
}
