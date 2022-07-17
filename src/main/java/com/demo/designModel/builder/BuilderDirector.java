package com.demo.designModel.builder;

public class BuilderDirector {
	 public Person constructPerson(Builder bd) {  
		 bd.buildHead();  
		 bd.buildBody();  
		 bd.buildFoot();  
         return bd.buildPerson();  
    } 
}
