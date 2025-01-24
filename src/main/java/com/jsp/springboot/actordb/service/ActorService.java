package com.jsp.springboot.actordb.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.utility.ResponceStructure;

public interface ActorService {
	public ResponseEntity<ResponceStructure<Actor>> addActor(Actor actor);
	
	public ResponseEntity<ResponceStructure<List<Actor>>> findAllActors();
	
	public ResponseEntity<ResponceStructure<Actor>> findByActorId(int actorId);
	
	public ResponseEntity<ResponceStructure<Actor>> updateByActorId(int actorId, Actor updateActor);
	
	public ResponseEntity<ResponceStructure<Actor>> deleteActorById(int actorId);
	
	public ResponseEntity<ResponceStructure<List<Actor>>> findByActorName(String actorName);
	
	public ResponseEntity<ResponceStructure<List<Actor>>> findByAge(int age);
	
	public ResponseEntity<ResponceStructure<List<Actor>>> findByAgeBetween(int age1 ,int age2);
	
	public ResponseEntity<ResponceStructure<List<Actor>>> findByIndustry(String industry);




	

}
