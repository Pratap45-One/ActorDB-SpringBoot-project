package com.jsp.springboot.actordb.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.exception.ActorNotFoundByAgeException;
import com.jsp.springboot.actordb.exception.ActorNotFoundByIdException;
import com.jsp.springboot.actordb.exception.ActorNotFoundByIndustryException;
import com.jsp.springboot.actordb.exception.ActorNotFoundByNameException;
import com.jsp.springboot.actordb.repository.ActorRepository;
import com.jsp.springboot.actordb.service.ActorService;
import com.jsp.springboot.actordb.utility.ResponceStructure;

@Service
public class ActorServiceimpl implements ActorService {
	@Autowired
	private ActorRepository actorRepository;

	public ResponseEntity<ResponceStructure<Actor>> addActor(Actor actor) {
		Actor actor1 = actorRepository.save(actor);

		ResponceStructure<Actor> responceStructure = new ResponceStructure<Actor>();
		responceStructure.setStatusCode(HttpStatus.CREATED.value());
		responceStructure.setMessage("Actor added Sucessfully");
		responceStructure.setActor(actor1);

		return new ResponseEntity<ResponceStructure<Actor>>(responceStructure, HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<ResponceStructure<List<Actor>>> findAllActors() {

		List<Actor> actors = actorRepository.findAll();
		if (actors.isEmpty()) {
			throw new ActorNotFoundByIdException("Actors not found");
			} else {
			ResponceStructure<List<Actor>> responceStructure = new ResponceStructure<List<Actor>>();
			responceStructure.setStatusCode(HttpStatus.FOUND.value());
			responceStructure.setMessage("Actor added Sucessfully");
			responceStructure.setActor(actors);
			return new ResponseEntity<ResponceStructure<List<Actor>>>(responceStructure, HttpStatus.FOUND);
		}

	}

	@Override
	public ResponseEntity<ResponceStructure<Actor>> findByActorId(int actorId) {
		Optional<Actor> optional = actorRepository.findById(actorId);
		if (optional.isEmpty()) {
			throw new ActorNotFoundByIdException("Actor not found");		} else {
			Actor actor = optional.get();
			ResponceStructure<Actor> responceStructure = new ResponceStructure<Actor>();
			responceStructure.setStatusCode(HttpStatus.FOUND.value());
			responceStructure.setMessage("Actor found Sucessfully");
			responceStructure.setActor(actor);
			return new ResponseEntity<ResponceStructure<Actor>>(responceStructure, HttpStatus.FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponceStructure<Actor>> updateByActorId(int actorId, Actor updateActor) {
		Optional<Actor> optional = actorRepository.findById(actorId);
		if (optional.isPresent()) {
			Actor existingActor = optional.get();
			updateActor.setActorId(existingActor.getActorId());
			Actor actor = actorRepository.save(existingActor);
			ResponceStructure<Actor> responceStructure = new ResponceStructure<Actor>();
			responceStructure.setStatusCode(HttpStatus.CREATED.value());
			responceStructure.setMessage("Actor updated Sucessfully");
			responceStructure.setActor(updateActor);
			return new ResponseEntity<ResponceStructure<Actor>>(responceStructure, HttpStatus.CREATED);

		} else {
			throw new ActorNotFoundByIdException("Actor not found");		}
	}

	@Override
	public ResponseEntity<ResponceStructure<Actor>> deleteActorById(int actorId) {
		Optional<Actor> optional = actorRepository.findById(actorId);

		if (optional.isPresent()) {
			Actor existingActor = optional.get();

			actorRepository.delete(existingActor);
			ResponceStructure<Actor> responceStructure = new ResponceStructure<Actor>();
			responceStructure.setStatusCode(HttpStatus.OK.value());
			responceStructure.setMessage("Actor Deleted Sucessfully");
			responceStructure.setActor(existingActor);
			return new ResponseEntity<ResponceStructure<Actor>>(responceStructure, HttpStatus.OK);
		} else {
			throw new ActorNotFoundByIdException("Actor not found");
		}
	}

	@Override
	public ResponseEntity<ResponceStructure<List<Actor>>> findByActorName(String actorName) {
		List<Actor> actors = actorRepository.findByActorName(actorName);
		if (actors.isEmpty()) {
			throw new ActorNotFoundByNameException("Actor not found by Name");

		} else {
			ResponceStructure<List<Actor>> responceStructure = new ResponceStructure<List<Actor>>();
			responceStructure.setStatusCode(HttpStatus.FOUND.value());
			responceStructure.setMessage("Actor found by name Sucessfully");
			responceStructure.setActor(actors);
			return new ResponseEntity<ResponceStructure<List<Actor>>>(responceStructure, HttpStatus.FOUND);

		}

	}

	@Override
	public ResponseEntity<ResponceStructure<List<Actor>>> findByAge(int age) {
		List<Actor> actors = actorRepository.findByAge(age);
		if (actors.isEmpty()) {
			throw new ActorNotFoundByIdException("Actor not found");

		} else {
			ResponceStructure<List<Actor>> responceStructure = new ResponceStructure<List<Actor>>();
			responceStructure.setStatusCode(HttpStatus.FOUND.value());
			responceStructure.setMessage("Actor found by age Sucessfully");
			responceStructure.setActor(actors);
			return new ResponseEntity<ResponceStructure<List<Actor>>>(responceStructure, HttpStatus.FOUND);

		}

	}

	@Override
	public ResponseEntity<ResponceStructure<List<Actor>>> findByAgeBetween(int age1, int age2) {
		List<Actor> actors = actorRepository.findByAgeBetween(age1, age2);
		if (actors.isEmpty()) {
			throw new ActorNotFoundByAgeException("Actor between age not found");

		} else {
			ResponceStructure<List<Actor>> responceStructure = new ResponceStructure<List<Actor>>();
			responceStructure.setStatusCode(HttpStatus.FOUND.value());
			responceStructure.setMessage("Actor found by age between Sucessfully");
			responceStructure.setActor(actors);
			return new ResponseEntity<ResponceStructure<List<Actor>>>(responceStructure, HttpStatus.FOUND);

		}
	}

	@Override
	public ResponseEntity<ResponceStructure<List<Actor>>> findByIndustry(String industry) {
		List<Actor> actors = actorRepository.findByIndustry(industry);
		if (actors.isEmpty()) {
			throw new ActorNotFoundByIndustryException("Actor not found by industry");

		} else {
			ResponceStructure<List<Actor>> responceStructure = new ResponceStructure<List<Actor>>();
			responceStructure.setStatusCode(HttpStatus.FOUND.value());
			responceStructure.setMessage("Actor found by industry between Sucessfully");
			responceStructure.setActor(actors);
			return new ResponseEntity<ResponceStructure<List<Actor>>>(responceStructure, HttpStatus.FOUND);

		}

	}

}
