package com.demo.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * 单线程计算复数之和
 */
public class SinglePrimeCountActor {
	public static void main(String[] args) {
		ActorSystem create = ActorSystem.create();
		ActorRef actorOf = create.actorOf(Props.create(CountActor2.class));
		actorOf.tell("work", ActorRef.noSender());
		System.out.println(Thread.currentThread()+" :end");
	}
	
//	private static int count = 0;
//	public static void main(String[] args) {
//		long currentTimeMillis = System.currentTimeMillis();
//		for(int i = 2; i <= 100000; i++){
//			System.out.println(Thread.currentThread()+" ===num=== "+ i);
//			boolean prime = isPrime(i);
//			if(prime){
//				count++;
//			}
//		}
//		System.out.println(count);
//		System.out.println(System.currentTimeMillis() - currentTimeMillis);
//	}
//	
//	public static boolean isPrime(int num){
//		boolean flag = true; 
//		for(int i = 2; i< num-1; i++){
//			if(num % i == 0){
//				flag = false;
//			}
//		}
//		return flag;
//	}
	
}

class CountActor2 extends UntypedActor{
	private static int count = 0;
	
	@Override
	public void onReceive(Object message) throws Exception {
		if(message.equals("work")){
			long currentTimeMillis = System.currentTimeMillis();
			for(int i = 2; i <= 10000; i++){
				System.out.println(Thread.currentThread()+" ===num=== " + i);
				boolean prime = isPrime(i);
				if(prime){
					count++;
				}
			}
			System.out.println("数量："+count);
			System.out.println(System.currentTimeMillis() - currentTimeMillis);
		}
	}
	
	public static boolean isPrime(int num){
		boolean flag = true; 
		for(int i = 2; i< num-1; i++){
			if(num % i == 0){
				flag = false;
			}
		}
		return flag;
	}
}