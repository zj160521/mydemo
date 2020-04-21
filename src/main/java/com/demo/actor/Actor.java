package com.demo.actor;

import akka.actor.ActorRef;

public class Actor {
	private String msg;
	private Integer num;
	private ActorRef countActor;
	private long startTime;
	
	public long getStartTime() { return startTime; }
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public ActorRef getCountActor() {
		return countActor;
	}
	public void setCountActor(ActorRef countActor) {
		this.countActor = countActor;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

}
