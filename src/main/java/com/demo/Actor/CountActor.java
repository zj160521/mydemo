package com.demo.Actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import java.util.HashSet;
import java.util.Set;

/**
 * 统计个数actor
 * @author zhouj
 *
 */
public class CountActor extends UntypedActor{

	private int countTotal = 0;
	static Set<String> strList = new HashSet<String>();
	@Override
	public void onReceive(Object message) throws Exception {
		if(message instanceof Actor){
			Actor actor = (Actor) message;
			strList.add(getSender().path().toString());
			if(actor.getMsg().equals("count")){
				countTotal += actor.getNum();
			}
			
			if(strList.size() == 9){
				System.out.println("total : " + countTotal);
				System.out.println("timeCast : "+(System.currentTimeMillis()-actor.getStartTime()));
				for(String str : strList){
					System.out.println("str="+str);
				}
//				getContext().system().shutdown();//关闭整个actor系统
				getContext().stop(getSelf());
			}
		} else if(message.equals("isWork")){
			getSender().tell("I am working", ActorRef.noSender());
//			unhandled(message);
		}
	}

}
