package com.ghouse.votechyne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghouse.votechyne.model.BallotBox;

public interface BallotBoxRepository extends JpaRepository<BallotBox, Integer>{
	
	
}