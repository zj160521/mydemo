package com.demo.Actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Terminated;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ActorTest{

	private static long startTime;
	private static ActorRef countActor;
	private static ActorRef dispatcher;
	
	/**
	 * https://blog.csdn.net/qq_41610418/article/details/82287628
	 * akka在Java中的并发：
	 * 1.actor系统创建
	 * 2.actor的创建
	 * 3.子actor的创建
	 * 4.actor的选取  (getContext().actorSelection/system.actorSelection)
	 * 5.actor之间消息的传递
	 * 6.父actor的监督策略：一种是OneForOneStrategy的监督（针对单个子actor实施策略），另一种是AllForOneStrategy（针对所有子actor实施策略）
	 * 注意：父子actor不能共用所传递的消息对象
	 * 7.消息邮箱
	 * @param args
	 */
	public static void main(String[] args) throws TimeoutException {
		startTime = System.currentTimeMillis();
		ActorSystem system = ActorSystemTools.start();// 1
		dispatcher = ActorSystemTools.actorOf(DispatcherActor.class, "dispatcher");// 2	创建分发者
		countActor = ActorSystemTools.actorOf(CountActor.class, "countActor");// 2	创建合集者
		for(int i = 0; i < 3; i++){
			Actor actor = new Actor();//各个producer不能共用信息对象
			actor.setCountActor(countActor);
			actor.setMsg("workwork");
			actor.setNum(0);
			actor.setStartTime(startTime);
			ActorRef producer = ActorSystemTools.actorOf(ProducerActor.class, "producer"+i);// 3	创建子actor
			producer.tell(actor, dispatcher);
//			producer.tell(actor, ActorRef.noSender());
		}
		//能和actor通信的信箱
		Inbox inbox = Inbox.create(system);
		while(true){
			inbox.watch(countActor);
			inbox.send(countActor, "isWork");
			Object msg = inbox.receive(Duration.create(1, TimeUnit.SECONDS));
			if(msg instanceof Terminated) {
				System.out.println("---->>My countActor is dead");
//				system.shutdown();
				break;
			}else{
				System.out.println(">>>>>> " + msg);
			}
		}
		 
	}
	
	public static long getStartTime(){
		return startTime;
	}

	public static ActorRef getCountActor() {
		return countActor;
	}
	
	public static ActorRef getDispatcher() {
		return dispatcher;
	}
	
}
