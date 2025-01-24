package com.jsp.springboot.actordb.exception;

public class ActorNotFoundByNameException extends RuntimeException {
	
	public String Message;

	public ActorNotFoundByNameException(String message) {
		super();
		Message = message;
	}
	
	public String getMessage() {
		return Message;
	}

}
