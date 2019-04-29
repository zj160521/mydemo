package com.demo.factorymethodandthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Factory {

	protected static ExecutorService es =  Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	public abstract void make();
	
	
}
