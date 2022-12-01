package com.demo.io_Serializable.socket;

import java.io.*;
import java.net.Socket;

public class TestSocketClient {

	public static void main(String[] args) throws  IOException {
		Socket sc = new Socket("localhost", 998);
		OutputStream os = sc.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.println("hello");
		pw.println("sk");
		pw.flush();
		sc.shutdownOutput();

		InputStream inputStream = sc.getInputStream();
		BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
		String line = bf.readLine();
		while (line != null) {
			System.out.println(line);
			line = bf.readLine();
		}
		// 关流从最近的开始关
		bf.close();
		inputStream.close();
		pw.close();
		os.close();
		sc.close();
	}

}
