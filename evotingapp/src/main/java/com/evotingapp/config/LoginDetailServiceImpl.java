package com.evotingapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.evotingapp.dao.LoginRepository;
import com.evotingapp.model.Login;

public class LoginDetailServiceImpl implements UserDetailsService  {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Login login=loginRepository.getLoginByUserName(username);
		
		if(login==null) {
			throw new UsernameNotFoundException("could not found user");
		}
		
		CustomLoginDetails customUserDetails= new CustomLoginDetails(login);
		//CutomUserDetails customUserDetails=new CutomUserDetails(user);
		
		return customUserDetails;
	}

	

}
