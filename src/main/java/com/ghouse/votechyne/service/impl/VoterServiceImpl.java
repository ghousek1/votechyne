package com.ghouse.votechyne.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghouse.votechyne.exceptions.NoSuchVoterFound;
import com.ghouse.votechyne.exceptions.NullCheckException;
import com.ghouse.votechyne.model.Voter;
import com.ghouse.votechyne.repository.VoterRepository;
import com.ghouse.votechyne.service.VoterService;

@Service
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterRepository voterRepository;

	@Override
	public Voter addVoter(Voter voter) {
		System.out.println(voter);
		if (voter.getVoterName() == null || voter.getVoterEmail() == null || voter.getVoterPhone() == null) {
			throw new NullCheckException("NULL VALUE NOT ALLOWED");
		} else {
			return voterRepository.save(voter);
		}

	}

	@Override
	public List<Voter> getVoters() {
		List<Voter> voters = (List<Voter>) voterRepository.findAll();
		System.out.println(voters);
		List<Voter> sortedVoters = (List<Voter>) voters.stream()
				.sorted(Comparator.comparing(Voter::getVoterName).thenComparing(Voter::getVoterEmail))
				.collect(Collectors.toList());
		return sortedVoters;
	}

	@Override
	public Voter getVoter(int VoterId) {
		Optional<Voter> voter = voterRepository.findById(VoterId);
		System.out.println(voter);
		if (voter.isEmpty()) {
			throw new NoSuchVoterFound("NO Voter FOUND");
		} else {
			return voter.get();

		}
	}

	@Override
	public void deleteVoterById(int voterId) {
		voterRepository.deleteById(voterId);

	}

	@Override
	public void updateVoter(int voterId, Voter voter) {
		voter.setVoterId(voterId);
		System.out.println(voter);
		voterRepository.save(voter);

	}

}
