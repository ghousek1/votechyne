package com.ghouse.votechyne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ghouse.votechyne.model.Voter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

//web View controller
@RequestMapping("/votechyne")
public class VotechyneController {


	@RequestMapping("/")
	public String indexpage() {
		log.info("votechyne HomePage Loaded In Browser");
		return "index";

	}

	@RequestMapping("/addvotermenu")
	public String addVoterPage(Model model) {
		Voter voter = new Voter();
		model.addAttribute("voter", voter);
		log.info(" Add voter Page Loaded In Browser");
		return "addvoter";
	}

	@RequestMapping("/searchvotermenu")
	public String searchVoterPage(Model model) {

		log.info("Search voter Page Loaded In Browser");
		return "searchvoter";
	}


	@RequestMapping("/showvotersmenu")
	public String showVotersPage(Model model) {

		log.info("Show Orchard Minds Page Loaded In Browser");
		return "showvoters";
	}


	@RequestMapping("/updatevotermenu")
	public String updateVoterPage(Model model) {

		log.info(" Update voter Page Loaded In Browser");
		return "updatevoter";
	}
	
	

	@RequestMapping("/ballotboxvotingmenu")
	public String ballotBoxVotingPage(Model model) {

		log.info("ballotboxvoting Page Loaded In Browser");
		return "ballotboxvoting";
	}

	
}
