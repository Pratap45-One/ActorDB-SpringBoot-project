package com.jsp.springboot.actordb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jsp.springboot.actordb.controller.ActorController;
import com.jsp.springboot.actordb.entity.Actor;

@SpringBootApplication
public class SpringBootActordbApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootActordbApplication.class, args);
	
	}

}
