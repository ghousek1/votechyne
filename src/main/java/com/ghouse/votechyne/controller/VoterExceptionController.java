package com.ghouse.votechyne.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ghouse.votechyne.exceptions.ExceptionResponse;
import com.ghouse.votechyne.exceptions.NoSuchVoterFound;



@ControllerAdvice
public class VoterExceptionController {
	@ExceptionHandler(value=NoSuchVoterFound.class)
	
	public ResponseEntity<Object> exception(NoSuchVoterFound exception) throws Exception{
	   
		//System.out.println(exception.getMessage());
		
		ExceptionResponse response=new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("Votehchyne-App exception");
		ResponseEntity<Object> entity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		return entity;
		
	}

}
