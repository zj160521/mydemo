package com.demo.actor;

import akka.actor.UntypedActor;

/**
 * 分发数字actor
 * @author zhouj
 *
 */
public class DispatcherActor extends UntypedActor {
	
	private int number = 2;
	public void onReceive(Object message) throws Exception {
		if(message instanceof Actor){
			Actor actor = (Actor) message;
			if(actor.getMsg().equals("I need a num")){
				if(number <= 10000){
					actor.setMsg("num");
					actor.setNum(number);
					number++;
				}else{
					actor.setMsg("no more num");
				}
				getSender().tell(actor, getSelf());
			}
		}else{ unhandled(message); }
	}
	
	@Override
	public void postStop() throws Exception {
		System.out.println("XXXXdispatcher要关闭了！XXXX");
	}
	@Override
	public void preStart() throws Exception {
		System.out.println("》》》我要开始分配数字了！");
	}
	
}
