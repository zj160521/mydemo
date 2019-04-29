package com.demo.Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(new Date().getSeconds()+"  hello");
			}
		}, 5000, 2000);
	}
}
