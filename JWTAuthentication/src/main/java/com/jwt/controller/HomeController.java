package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.User;
import com.jwt.repo.UserRepository;

@RestController
public class HomeController {

	
	/*@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	*/
	
	@RequestMapping("/welcome")
	public String welcome() {
		String text="This is private page";
		return text;
		
	}
	
	@Autowired
	private UserRepository userRepository;
	 
	@RequestMapping(value = "/do_register",method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) {
		
		try {
			
			//user.setPassword(passwordEncoder.encode(user.getPassword()));
			System.out.println("USER ::" +user);
			User result=this.userRepository.save(user);
			String message="User recorded successfully..";
			System.out.println("User recorded successfully..");
			return message;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
