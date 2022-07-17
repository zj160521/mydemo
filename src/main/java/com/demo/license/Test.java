package com.demo.license;

import com.demo.aes2.AESUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String cpuCode = CPUCode.getCPUCode();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		String endTime = sdf.format(cal.getTime());
		String license = GenerateLicense.getLicense(cpuCode, endTime);
		
		
		String decrypt = AESUtil.decrypt(license, "963258");
		System.out.println("963258:" + decrypt);
		String[] split = decrypt.split("&");
		System.out.println(split[1]);
		try {
			Date parse = sdf.parse(split[1]);
			Date now = new Date();
			if(parse.getTime() >= now.getTime()){
				System.out.println("是否过期："+ true);
			}else{
				System.out.println("是否过期："+ false);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
