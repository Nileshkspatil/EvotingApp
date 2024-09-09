package com.evotingapp.controller;

import java.lang.ProcessBuilder.Redirect;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evotingapp.dao.CandidateRepository;
import com.evotingapp.dao.LoginRepository;
import com.evotingapp.helper.Message;
import com.evotingapp.model.Candidate;
import com.evotingapp.model.Login;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/voter")
public class VoterController {
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping("/evm")
	public String evm(Model model, Principal Principal , HttpSession session) {
		String name=Principal.getName();
		Login loginuser=loginRepository.getLoginByUserName(name);
		
		if(loginuser.getIsvoted()) {
			
			session.setAttribute("message", new Message("You have already cast voted !!!!!!!", "danger"));
			 return "redirect:/signin";
		}
		
		List<Candidate> candidate=candidateRepository.findAll();	
		
		model.addAttribute("candidate", candidate);
		model.addAttribute("title", "evm");
		
		return "voter/evm";
	}
	
	@PostMapping("/vvpad/{cid}")
	public String vvpad(@PathVariable("cid") int cid, HttpSession session, Model model, Principal Principal) {
			Candidate candidate=candidateRepository.findById(cid).get();
			
			int vote=candidate.getVote();
			vote=vote+1;
			candidate.setVote(vote);
			String name=Principal.getName();
			Login loginuser=loginRepository.getLoginByUserName(name);
			loginuser.setIsvoted(true);
			candidateRepository.save(candidate);
			model.addAttribute("candidate", candidate);
			model.addAttribute("title", "VVpad");
		
		
		return "voter/vvpad";
		
	}
	

}
