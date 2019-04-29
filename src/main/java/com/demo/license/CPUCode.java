package com.demo.license;

import java.io.IOException;
import java.util.Scanner;

public class CPUCode {
	@SuppressWarnings("resources")
	public static String getCPUCode() {   
	    try {    
	        Process process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });
	        process.getOutputStream().close();
	        Scanner sc = new Scanner(process.getInputStream());
	        String property = sc.next();
	        String serial = sc.next();
	        System.out.println(property+"=="+serial);
	        return serial;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
