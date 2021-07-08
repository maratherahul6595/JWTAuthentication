package com.jwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.config.CustomUserDetails;
import com.jwt.repo.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if(username.equals("Rahul")) {
			return new User("Rahul","Rahul123", new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("Username not found exception..");
		}
	}
	
	/* import com.jwt.model.User;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//fetching user from db
				User user = userRepository.getUserByUserName(username);
				
				if(user==null) {
					throw new UsernameNotFoundException("Could not found user!!");
				}
				
				CustomUserDetails customUserDetails=new CustomUserDetails(user);
				
				return customUserDetails;
	}*/

}
