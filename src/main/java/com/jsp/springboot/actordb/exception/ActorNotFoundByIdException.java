package com.jsp.springboot.actordb.exception;

public class ActorNotFoundByIdException extends RuntimeException{
	
	private String Message;

	public ActorNotFoundByIdException(String message) {
		super();
		this.Message = message;
	}
	
	public String getMessage() {
		return Message;
	}
	
	

}
