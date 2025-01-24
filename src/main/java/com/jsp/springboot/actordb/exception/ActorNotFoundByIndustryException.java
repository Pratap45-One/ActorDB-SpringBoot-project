package com.jsp.springboot.actordb.exception;

public class ActorNotFoundByIndustryException extends RuntimeException {
	
	private String Message;

	public ActorNotFoundByIndustryException(String message) {
		super();
		this.Message = message;
	}
	
	
	public String getMessage() {
		return Message;
		
	}

}
