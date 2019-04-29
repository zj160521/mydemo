package com.demo.Actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

/**
 * 计算actor
 * @author zhouj
 *
 */
public class ChildProducerActor extends UntypedActor {

	private int numCount = 0;
	private ActorRef countActor = null;
	
	@Override
	public void preStart() throws Exception {
		countActor = ActorTest.getCountActor();
	}

	@Override
	public void postStop() throws Exception {
		System.out.println(getSelf().path()+"--XXX");
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if(message instanceof Actor){
			Actor actor = (Actor) message;
			if(actor.getMsg().equals("workwork")){
//				double a = 0/0;
				actor.setMsg("I need a num");
				getSender().tell(actor, getSelf());
			}else if(actor.getMsg().equals("num")){
				boolean prime = isPrime(actor.getNum());
				if(prime){
					numCount += 1;
				}
				actor.setMsg("I need a num");
				getSender().tell(actor, getSelf());
			}else if(actor.getMsg().equals("no more num")){
				actor.setNum(numCount);
				actor.setMsg("count");
				countActor.tell(actor, getSelf());
//				getContext().parent().tell(PoisonPill.getInstance(), ActorRef.noSender());//关闭父actor
				getContext().stop(getSelf());//关闭自己
			}
		}else { unhandled(message); }
	}
	
	public boolean isPrime(int num){
		boolean flag = true; 
		for(int i = 2; i< num-1; i++){
			if(num % i == 0){
				flag = false;
			}
		}
		return flag;
	}
}
