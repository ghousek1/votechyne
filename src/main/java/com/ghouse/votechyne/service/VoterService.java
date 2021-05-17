package com.ghouse.votechyne.service;

import java.util.List;

import com.ghouse.votechyne.model.Voter;

public interface VoterService{

	Voter addVoter(Voter voter);

	List<Voter> getVoters();

	Voter getVoter(int voterId);

	void deleteVoterById(int voterId);

	void updateVoter(int voterId, Voter voter);
	
	
}