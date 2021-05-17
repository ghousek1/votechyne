package com.ghouse.votechyne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ghouse.votechyne.model.BallotBox;
import com.ghouse.votechyne.model.ServiceResponse;
import com.ghouse.votechyne.service.BallotBoxService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ballotbox")
public class BallotBoxController {


	
	@Autowired
	private BallotBoxService ballotBoxService;

	@PostMapping(value="/",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<Object> addBallotBox(@RequestBody BallotBox ballotBox) {
		log.info("New BallotBox Added");
		ballotBoxService.addBallotBox(ballotBox);
		ServiceResponse<BallotBox> response = new ServiceResponse<BallotBox>("success",ballotBox);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}



}
