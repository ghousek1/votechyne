package com.ghouse.votechyne;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ghouse.votechyne.model.Voter;
import com.ghouse.votechyne.repository.VoterRepository;
import com.ghouse.votechyne.service.VoterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoterServiceTest {
	
	@Autowired
	VoterService voterService;
	
	@MockBean
	VoterRepository voterRepository;

	@Test
	public void testAddVoter() {
		Voter dummyVoter1=new Voter(1001,"dummyVoterName1", 20, "dummy1@email.com","0000000001","dummyCity1");
	Mockito.when(voterRepository.save(dummyVoter1)).thenReturn(dummyVoter1);
	assertSame(dummyVoter1,voterService.addVoter(dummyVoter1));
		
		
	}
	
	@Test
	public void testGetVoters() {
	Voter dummyVoter1=new Voter(1001,"dummyVoterName1", 20, "dummy1@email.com","0000000001","dummyCity1");
	Voter dummyVoter2=new Voter(1002,"dummyVoterName2", 21, "dummy2@email.com","000000002","dummyCity2");
	Voter dummyVoter3=new Voter(1003,"dummyVoterName3", 22, "dummy3@email.com","000000003","dummyCity3");
	Voter dummyVoter4=new Voter(1004,"dummyVoterName4", 23, "dummy4@email.com","000000004","dummyCity4");
	
	List<Voter> dummyVoters=new ArrayList<Voter>();
	dummyVoters.add(dummyVoter1);
	dummyVoters.add(dummyVoter2);
	dummyVoters.add(dummyVoter3);
	dummyVoters.add(dummyVoter4);
	
	
	Mockito.when(voterRepository.findAll()).thenReturn(dummyVoters);
	assertEquals(dummyVoters,voterService.getVoters());
		
		
	}
	
	@Test
	public void testGetVoter() {
	Voter dummyVoter1=new Voter(1001,"dummyVoterName1", 20, "dummy1@email.com","0000000001","dummyCity1");
	Optional<Voter> dummyVoter1Opt=Optional.of(dummyVoter1);
	Mockito.when(voterRepository.findById(1001)).thenReturn(dummyVoter1Opt);
	assertSame(dummyVoter1Opt.get(),voterService.getVoter(1001));
	
	//Assertions.assertThat(actualResponse).equalTo(expectedResponse);
		
		
	}
   
	
	public void testDeleteVoter() {
	voterRepository.deleteById(1001);
	//assertSame(dummyVoter1Opt.get(),voterService.getVoter(1001));
	
	//Assertions.assertThat(actualResponse).equalTo(expectedResponse);
		
		
	}
}
