package com.ghouse.votechyne.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NullCheckException extends RuntimeException{
	
	
	public NullCheckException() {
		super();
	}
	public NullCheckException(String expMessage) {
		super(expMessage);
	    log.error("No such Exception Handled by Postman not in console");
		
	}

}
