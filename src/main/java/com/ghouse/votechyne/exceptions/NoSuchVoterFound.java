package com.ghouse.votechyne.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoSuchVoterFound extends RuntimeException{
	
	
	public NoSuchVoterFound() {
		super();
	}
	public NoSuchVoterFound(String expMessage) {
		super(expMessage);
	    log.error("No such Exception Handled by Postman not in console");
		
	}

}
