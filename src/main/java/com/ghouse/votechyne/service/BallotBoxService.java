package com.ghouse.votechyne.service;

import org.springframework.stereotype.Service;

import com.ghouse.votechyne.model.BallotBox;

@Service
public interface BallotBoxService {

	void addBallotBox(BallotBox ballotBox);

}
