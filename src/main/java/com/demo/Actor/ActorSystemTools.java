package com.demo.Actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * @author cyd
 * @date 2015-3-24
 */
public class ActorSystemTools {
 
	private static ActorSystem actorSystem = null;
	
	/**
	 * 启动actor系统
	 * @return
	 */
	public static ActorSystem start() {
		System.out.println("start actorSystem...");
		actorSystem = ActorSystem.create();
		return actorSystem;
	}
	
	public static ActorSystem getActorSystem() {
		return actorSystem;
	}
	
	/**
	 * 创建actor
	 * @param clazz Actor类
	 * @param actorName Actor名字
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ActorRef actorOf(Class clazz, String actorName) {
		System.out.println("创建'"+actorName+"'Actor");
		return actorSystem.actorOf(Props.create(clazz), actorName);
//		return actorSystem.actorOf(Props.create(clazz));
	}
}

