package com.demo.Actor;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

public class ActorStrategyTest {
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("lifecycle",ConfigFactory.load("lifecycle.conf"));
		customStrategy(system);
	}
	
	public static void customStrategy(ActorSystem system) {
		ActorRef supervisorActor = system.actorOf(Props.create(Supervisor.class),"Supervisor");
		supervisorActor.tell(Props.create(RestartActor.class), ActorRef.noSender());//strategyActor下新建子actor:restartActor
	 
		ActorSelection sel = system.actorSelection("akka://lifecycle/user/Supervisor/restartActor");
		for(int i=0; i<100; i++) {
			sel.tell(RestartActor.Msg.RESTART, ActorRef.noSender());
		}
	}
}
