package com.jsp.springboot.actordb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.service.ActorService;
import com.jsp.springboot.actordb.utility.ResponceStructure;

//@Controller
//@ResponseBody // to bind the method with https responce
@RestController
@RequestMapping("/actors")
public class ActorController {
	@Autowired
	private ActorService actorservice;

	// ActorService actorservice=new ActorServiceImpl();
//	@RequestMapping(value = "/actors", method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<ResponceStructure<Actor>> addActor(@RequestBody Actor actor) {
		return actorservice.addActor(actor);

	}

	@GetMapping
	// @RequestMapping(value = "/actors", method = RequestMethod.GET)
	public ResponseEntity<ResponceStructure<List<Actor>>> findAllActors() {

		return actorservice.findAllActors();
	}

	@GetMapping("/id")

	// @RequestMapping(value = "/actors/id", method = RequestMethod.GET)
	public ResponseEntity<ResponceStructure<Actor>> findByActorId(int actorId) {
		return actorservice.findByActorId(actorId);

	}

	@PutMapping

	// @RequestMapping(value = "/actors", method = RequestMethod.PUT)
	public ResponseEntity<ResponceStructure<Actor>> updateByActorId(int actorId, @RequestBody Actor updatedActor) {
		return actorservice.updateByActorId(actorId, updatedActor);

	}

	@DeleteMapping

	// @RequestMapping(value = "/actors", method = RequestMethod.DELETE)
	public ResponseEntity<ResponceStructure<Actor>> deleteActorById(int actorId) {
		return actorservice.deleteActorById(actorId);
	}

	@GetMapping("/name")

	// @RequestMapping(value = "/actors/name", method = RequestMethod.GET)
	public ResponseEntity<ResponceStructure<List<Actor>>> findByActorName(String actorName) {
		return actorservice.findByActorName(actorName);

	}

	@GetMapping("/age")

	// @RequestMapping(value = "/actors/age", method = RequestMethod.GET)
	public ResponseEntity<ResponceStructure<List<Actor>>> findByAge(int age) {
		return actorservice.findByAge(age);

	}

	@GetMapping("/agebetween")

	// @RequestMapping(value = "/actors/agebetween", method = RequestMethod.GET)
	public ResponseEntity<ResponceStructure<List<Actor>>> findByAgeBetween(int age1, int age2) {
		return actorservice.findByAgeBetween(age1, age2);

	}

	@GetMapping("/industry")

	// @RequestMapping(value = "/actors/industry", method = RequestMethod.GET)
	public ResponseEntity<ResponceStructure<List<Actor>>> findByIndustry(String industry) {
		return actorservice.findByIndustry(industry);
	}

}
