package com.demo.Actor;

import akka.actor.*;
import akka.actor.SupervisorStrategy.Directive;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * 计算actor
 * @author zhouj
 *
 */
public class ProducerActor extends UntypedActor {

	private int numCount = 0;
	private ActorRef countActor = null;
	
	private static SupervisorStrategy strategy = new OneForOneStrategy(0, Duration.create(1,TimeUnit.MINUTES), //1分钟内进行2次重试，超过就kill次actor
			new Function<Throwable, Directive>() {//具体的策略定义
		@Override
		public Directive apply(Throwable t) throws Exception {
			if(t instanceof ArithmeticException) {
				System.out.println("meet ArithmeticException,just resume");
				return SupervisorStrategy.resume();//继续指定这个Actor，不做任何处理
			} else if(t instanceof NullPointerException) {
				System.out.println("meeting NullPointerException,restart");
				return SupervisorStrategy.restart();//进行Actor的重启,重启会新起一个actor
			} else if(t instanceof IllegalArgumentException) {
				return SupervisorStrategy.stop();//停止actor
			} else {
				return SupervisorStrategy.escalate();//向上抛出，由更顶层的Actor处理
			}
		}
	});
	
	@Override
	public void preStart() throws Exception {
		countActor = ActorTest.getCountActor();
		for(int i = 0; i < 2;i++){//新建两个子actor
			ActorRef actorOf = getContext().actorOf(Props.create(ChildProducerActor.class), "child"+i);
			Actor childActor = new Actor();
			childActor.setCountActor(countActor);
			childActor.setMsg("workwork");
			childActor.setNum(0);
			childActor.setStartTime(ActorTest.getStartTime());
			actorOf.tell(childActor, ActorTest.getDispatcher());//向子actor传递消息
		}
	}
	
	@Override
	public void postStop() throws Exception {
		System.out.println("告诉我"+getSelf().path()+"  该关闭了");
	}
	
	@Override
	public SupervisorStrategy supervisorStrategy() {
		return strategy;
	}



	@Override
	public void onReceive(Object message) throws Exception {
		if(message instanceof Actor){
			Actor actor = (Actor) message;
			if(actor.getMsg().equals("workwork")){
				actor.setMsg("I need a num");
				getSender().tell(actor, getSelf());//向分发者请求数据
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
				getContext().actorSelection("/user/countActor").tell(actor, getSelf());//actor选择
			}
		}else{
			unhandled(message);
		}
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
