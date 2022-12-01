package com.demo.io_Serializable.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhoujie
 */
public class TestSocketServer {
	ServerSocket serverSocket;
	ExecutorService executor;

	/**
	 * 初始化线程池和serverSocket
	 * @throws IOException
	 */
	public TestSocketServer() throws IOException {
		executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
				60L, TimeUnit.SECONDS, new SynchronousQueue<>());
		serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress(998));
	}

	public static void main(String[] args) throws IOException {
		TestSocketServer testSocket = new TestSocketServer();
		while (true) {
			// accept()是阻塞方法，有调用才会执行，否则一直阻塞在这里
			Socket sc = testSocket.serverSocket.accept();
			// 每个socket客户端需要一个线程取处理连接，否则会阻塞
			testSocket.executor.submit(new TestServerThread(sc));
		}
	}

}
