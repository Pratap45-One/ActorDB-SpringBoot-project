package com.jsp.springboot.actordb.utility;

import com.jsp.springboot.actordb.entity.Actor;

public class ResponceStructure <t> {
	private int statusCode;
	private String message;
	private t actor;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public t getActor() {
		return actor;
	}
	public void setActor(t actor) {
		this.actor = actor;
	}
	

}
