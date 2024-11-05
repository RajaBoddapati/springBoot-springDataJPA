package com.prac.springDataJpa.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.springDataJpa.entities.User;
import com.prac.springDataJpa.repositories.UserRepo;
import com.prac.springDataJpa.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public User createUser(User user) {	
		User createdUser =null;
		if(user !=null) {
			 createdUser = userRepo.save(user);
		}
		
		return createdUser;
	}
	public boolean userSignin(User user) {	
		if(user.getUsername()==null || user.getPassword()==null) {
			 throw new RuntimeException("Invalid credentails");
		}
	    
		User retreivedUser = userRepo.findByUsername(user.getUsername());
		System.out.println(retreivedUser);
		if(retreivedUser==null) {
			throw new RuntimeException("User not exist");
		}
		System.out.println(retreivedUser.getPassword()+" : "+user.getPassword());

		if(retreivedUser.getPassword().equals(user.getPassword())) {
			System.out.println(retreivedUser.getPassword()+" : "+user.getPassword());
			return true;
		}else {
			return false;
		}
		
		
	}

}
