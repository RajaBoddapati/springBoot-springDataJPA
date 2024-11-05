package com.prac.springDataJpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prac.springDataJpa.entities.ProfileRelEntity;
import com.prac.springDataJpa.entities.UserRelEntity;
import com.prac.springDataJpa.servicesImpl.UserRelServiceImpl;

@RestController
public class RelationshipController {
	
	@Autowired
	UserRelServiceImpl UserRelServiceImpl;
	
	
	@GetMapping("/relations-userrel")
	public List<UserRelEntity> getAllUserRels(){
		return UserRelServiceImpl.getAllUserRels();
		
	}
	
	@PostMapping("/relations-userrel")
	public ResponseEntity<UserRelEntity> createUserRel(@RequestBody UserRelEntity userRelEntity){
		UserRelServiceImpl.createUserRel(userRelEntity);
		return new ResponseEntity<UserRelEntity>(HttpStatus.CREATED);
		
	}
	@DeleteMapping("/relations-userrel/{id}")
	public boolean deleteUserRel(@PathVariable Integer id){
		UserRelServiceImpl.deleteUserRel(id);
		return true;
		
	}
	
	@PostMapping("/relations-profilerel")
	public ResponseEntity<ProfileRelEntity> createProfile(@RequestBody ProfileRelEntity profileRelEntity){
		UserRelServiceImpl.createProfileRel(profileRelEntity);
		return new ResponseEntity<ProfileRelEntity>(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/relations-profilerel/{id}")
	public boolean deleteProfileRel(@PathVariable Integer id){
		UserRelServiceImpl.deleteProfileRel(id);
		return true;
		
	}
}
