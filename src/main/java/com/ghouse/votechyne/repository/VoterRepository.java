package com.ghouse.votechyne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghouse.votechyne.model.Voter;

public interface VoterRepository extends JpaRepository<Voter, Integer>{
	
	
}