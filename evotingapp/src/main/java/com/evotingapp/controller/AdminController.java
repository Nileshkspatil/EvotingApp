package com.evotingapp.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.evotingapp.dao.CandidateRepository;
import com.evotingapp.model.Candidate;

import com.evotingapp.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@GetMapping("/add-contact")
	public String openAddcontactForm(Model model) {
		
		model.addAttribute("title", "Add Contact");
//		model.addAttribute("contact", new Contact());
		
		return "admin/add_contact_form";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		List<Candidate> candidate=candidateRepository.findAll();
		
		model.addAttribute("candidate", candidate);
		model.addAttribute("title", "dashboard");
		
		return "admin/dashboard";
	}
	
	@PostMapping("/process-condidate")
	public String processCandidateInfo(@Valid@ModelAttribute("candidate") Candidate candidate, @RequestParam("profileImage1") MultipartFile file1
			, @RequestParam("profileImage2") MultipartFile file2,BindingResult result,HttpSession session) { 
		
		try {
			//for profile photo
			candidate.setCandidatePhoto(file1.getOriginalFilename()+candidate.getEmail());
			 File savefile=new ClassPathResource("static/img").getFile();
			 
			 Path path=Paths.get(savefile.getAbsolutePath()+File.separator+candidate.getCandidatePhoto());
			 
			 Files.copy(file1.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
			 
			 System.out.println("profilephoto uploaded");
			 
			 //for symbol
			 
				candidate.setSymbol(file2.getOriginalFilename()+candidate.getMob());
				 File savefile2=new ClassPathResource("static/img").getFile();
				 
				 Path path2=Paths.get(savefile2.getAbsolutePath()+File.separator+candidate.getSymbol());
				 
				 Files.copy(file2.getInputStream(),path2,StandardCopyOption.REPLACE_EXISTING);
				 
				 System.out.println("symbol uploaded");
				 
				 candidateRepository.save(candidate);
			
				 session.setAttribute("message",new Message("Your candidate is successfully addded", "success"));
				
		}catch(Exception e) {
			
			System.out.println("Error:"+e.getMessage());
			e.printStackTrace();
			//error message
			session.setAttribute("message", new Message("Something went wrong try again!!", "danger"));
			
		}
				return "admin/add_contact_form";
	}
	
	//delete candidate
	@GetMapping("/delete-candidate/{cid}")
	public String deleteCanddidate(@PathVariable("cid") int cid, HttpSession session, Model model ) {
		
		Candidate candidate=candidateRepository.findById(cid).get();
		
		candidateRepository.delete(candidate);
		
		session.setAttribute("message",new Message("Your candidate is successfully deleted", "danger"));
		model.addAttribute("title","delete candidate");
		
		return "redirect:/admin/dashboard"; 
	}
	
	//update candidate
	
	@PostMapping("/update-candidate/{cid}")
	public String updateForm(@PathVariable("cid") int cid,Model model) {
		
		model.addAttribute("title","update candidate");
		
		Candidate candidate=candidateRepository.findById(cid).get();
		model.addAttribute("candidate", candidate);
		
		
		return"admin/update_form";
	}
	
	@PostMapping("/update-candidate")
	public String updateCandidate(@Valid@ModelAttribute("candidate") Candidate candidate, @RequestParam("profileImage1") MultipartFile file1
			, @RequestParam("profileImage2") MultipartFile file2,BindingResult result,HttpSession session,Model model) {
		
			try {
				Candidate oldcandidate=candidateRepository.findById(candidate.getCid()).get();
				
				if(!file1.isEmpty()) {
					
					//update new photo
					candidate.setCandidatePhoto(file1.getOriginalFilename()+oldcandidate.getEmail());
					
					 File savefile=new ClassPathResource("static/img").getFile();
					 
					 Path path=Paths.get(savefile.getAbsolutePath()+File.separator+candidate.getCandidatePhoto());
					 
					 Files.copy(file1.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
					 
					
				}
				
				else {
					candidate.setCandidatePhoto(oldcandidate.getCandidatePhoto());
					
				}
				
				if(!file2.isEmpty()) {
					
					candidate.setSymbol(file2.getOriginalFilename()+oldcandidate.getMob());
					 File savefile2=new ClassPathResource("static/img").getFile();
					 
					 Path path2=Paths.get(savefile2.getAbsolutePath()+File.separator+candidate.getSymbol());
					 
					 Files.copy(file2.getInputStream(),path2,StandardCopyOption.REPLACE_EXISTING);
				}else {
						
					candidate.setSymbol(oldcandidate.getSymbol());
					
					
				}
				
				
				
			candidateRepository.save(candidate);
				
			session.setAttribute("message", new Message("your candidate is updated", "success"));
			
			}catch (Exception e) {
			
				System.out.println("Error:"+e.getMessage());
				e.printStackTrace();
				//error message
				session.setAttribute("message", new Message("Something went wrong try again!!", "danger"));
				
			
			
			}
				
			model.addAttribute("title","update candidate");
		
		return "admin/update_form";
	}
	
	
	//result 
	@GetMapping("/result")
	public String showResult(Model model) {
		List<Candidate> candidate=candidateRepository.findAll();
		
		candidate.sort(Comparator.comparingLong(Candidate::getVote).reversed());
		
		model.addAttribute("candidate", candidate);
		
		
		return "admin/result";
	}
}
