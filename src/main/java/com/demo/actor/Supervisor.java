package com.demo.actor;

import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Restart：重新启动出现异常的Actor;
 * Stop：停掉出现异常的Actor；
 * Resume：忽略异常，保留其当前状态，继续执行；
 * Escalate：不知道如何处理，将异常向上抛出，交给自己的父亲执行。
 * @author zhouj
 *
 */
public class Supervisor extends UntypedActor {
	private static SupervisorStrategy strategy = new OneForOneStrategy(3, Duration.create(1,TimeUnit.MINUTES), 
			new Function<Throwable, Directive>() {
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
	
	/**
	 * 重写监测策略
	 */
	@Override
	public SupervisorStrategy supervisorStrategy() {
		return strategy;
	};

	@Override
	public void onReceive(Object o) {
		if(o instanceof Props) {
			getContext().actorOf((Props)o,"restartActor");
		} else {
			unhandled(o);
		}
	}
}
