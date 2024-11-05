package com.prac.springDataJpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prac.springDataJpa.entities.User;
import com.prac.springDataJpa.servicesImpl.UserServiceImpl;

//This controller is for User 

@RestController
@CrossOrigin("*")
public class Controller1 {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/signup")
	public User createUser(@RequestBody User user) {
		
		System.out.println(user);
		User createdUser = userServiceImpl.createUser(user);
		
		return createdUser;
	}
	@PostMapping("/signin")
	public boolean userSignin(@RequestBody User user) {
		
		System.out.println(user);
		boolean res = userServiceImpl.userSignin(user);
		
		return res;
	}

}
