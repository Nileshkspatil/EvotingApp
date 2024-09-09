package com.evotingapp.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evotingapp.dao.LoginRepository;
import com.evotingapp.helper.Message;
import com.evotingapp.model.Login;

import jakarta.servlet.http.HttpSession;



@Controller
public class HomeController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Evoting");
		
		return "home";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register- evoting");
		//model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/do_register")
	public String register(@ModelAttribute("login") Login login, HttpSession session) {
			
			Long [] mobile= { 7719852884L, 8378017738L};
			
			
			try {
				
				
				 // Check if the login's mobile number exists in the array
		        boolean isAdmin = Arrays.asList(mobile).contains(login.getMobileNumber());
		        
		        if (isAdmin) {
		            login.setRole("ROLE_Admin");
		        } else {
		            login.setRole("ROLE_User");
		            login.setIsvoted(false);
		        }
		
		        login.setPassword(passwordEncoder.encode(login.getPassword()));
			loginRepository.save(login);
			session.setAttribute("message", new Message("successfully Registered!!", "alert-success"));
		
				
			}catch(Exception e) {
				
				e.printStackTrace();
				
				 session.setAttribute("message", new Message("Something went wrong!!"+e.getMessage(), "alert-danger")); 
				 
				 return "signup";
				
			}
			
			return "signup";
		}
	
	@RequestMapping("/signin")
	public String customLogin(Model model) {
		
		model.addAttribute("title", "login page");
		
		return "login";
	}

}






















