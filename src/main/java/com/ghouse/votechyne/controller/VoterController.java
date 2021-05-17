package com.ghouse.votechyne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ghouse.votechyne.model.Voter;
import com.ghouse.votechyne.model.ServiceResponse;
import com.ghouse.votechyne.service.VoterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/voter")
public class VoterController {

	@Autowired
	private VoterService VoterService;

	@PostMapping(value="/",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<Object> addVoter(@RequestBody Voter voter) {
		log.info("New Voter Added");
		VoterService.addVoter(voter);
		ServiceResponse<Voter> response = new ServiceResponse<Voter>("success",voter);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<Object> getAllVoters() {

		List<Voter> voters = VoterService.getVoters();

		ServiceResponse<List<Voter>> votersData = new ServiceResponse("success", voters);

		return new ResponseEntity<Object>(votersData, HttpStatus.OK);

	}
	
	@GetMapping("/{voterId}")
	public ResponseEntity<Object> getVoterById(@PathVariable int voterId) {
		Voter voter = VoterService.getVoter(voterId);
		ServiceResponse<Voter> voterData = new ServiceResponse("success", voter);
		return new ResponseEntity<Object>(voterData, HttpStatus.OK);

	}

	@DeleteMapping("/{voterId}")
	public String deleteVoter(@PathVariable int voterId) {
		log.info("VoterDeleted!");
		VoterService.deleteVoterById(voterId);
		return "DELETED";
	}

	@PutMapping("/{voterId}")
	public String updateVoter(@RequestBody Voter voter,@PathVariable int voterId) {
		log.info("VoterUpdate!");
		VoterService.updateVoter(voterId,voter);
		return "UPDATED";
	}

}
