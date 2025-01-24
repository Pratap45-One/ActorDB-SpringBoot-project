package com.jsp.springboot.actordb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot.actordb.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	
	//save(Actor a)
	//findbyId(int actorId)
	//findAll
	//delete(Actor actor)
	//deletebyId(int actorId)
public List<Actor> findByActorName(String actorName);
public List<Actor> findByAge(int age);
public List<Actor> findByAgeBetween(int age1 ,int age2);
public List<Actor> findByIndustry(String industry);

//another way to having custom  function and process in repository     
//HQL-@query ("select a from Actor a where a.actorname=?1")                //write this @query annotation above the custom method

//public list<Actor> find by name(Sting actorName);


}

