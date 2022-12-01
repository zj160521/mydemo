package com.demo.io_Serializable.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class TestServerThread extends Thread {
	Socket sc;
	InputStream in;
	OutputStream outputStream;

	public TestServerThread(Socket sc) {
		this.sc = sc;
	}

	@Override
	public void run() {
		try {
			in = sc.getInputStream();
			List<String> lines = IOUtils.readLines(in);
			for (String line : lines) {
				System.out.println(line);
			}

			outputStream = sc.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.println("ni");
			printWriter.println("hao");
			outputStream.flush();
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
				in.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
