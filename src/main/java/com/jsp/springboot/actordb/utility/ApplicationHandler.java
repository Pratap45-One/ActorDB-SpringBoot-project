package com.jsp.springboot.actordb.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.jsp.springboot.actordb.exception.ActorNotFoundByAgeException;
import com.jsp.springboot.actordb.exception.ActorNotFoundByIdException;
import com.jsp.springboot.actordb.exception.ActorNotFoundByIndustryException;
import com.jsp.springboot.actordb.exception.ActorNotFoundByNameException;


@RestControllerAdvice
public class ApplicationHandler {
	@ExceptionHandler
	
	public ResponseEntity<ErrorStructure<String>> actorNotFoundById(ActorNotFoundByIdException ex){
		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setError("Actor with the required id is not avaliable in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
		
	}
	public ResponseEntity<ErrorStructure<String>> ActorNotFoundByAge(ActorNotFoundByAgeException ex){
		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setError("Actor with the required age is not avaliable in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
		
	}
	public ResponseEntity<ErrorStructure<String>> actorNotFoundByName(ActorNotFoundByNameException ex){
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setError("Actor with the required Name is not found in database");
		errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorStructure<String>>(errorStructure , HttpStatus.NOT_FOUND);
		
	}
	public ResponseEntity<ErrorStructure<String>> actorNotFoundByIndustry(ActorNotFoundByIndustryException ex){
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setError("Actor with the required Name is not found in database");
		errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorStructure<String>>(errorStructure , HttpStatus.NOT_FOUND);
		
	}

}
