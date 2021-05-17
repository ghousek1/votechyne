package com.ghouse.votechyne.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghouse.votechyne.model.BallotBox;
import com.ghouse.votechyne.repository.BallotBoxRepository;
import com.ghouse.votechyne.repository.VoterRepository;
import com.ghouse.votechyne.service.BallotBoxService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BallotBoxServiceImpl implements BallotBoxService {

	@Autowired
	private VoterRepository voterRepository;
	
	@Autowired
	private BallotBoxRepository ballotBoxRepository;



	@Override
	public void addBallotBox(BallotBox ballotBox) {
		ballotBoxRepository.save(ballotBox);
		
		
	}

}
