package com.prac.springDataJpa.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prac.springDataJpa.entities.ProfileRelEntity;
import com.prac.springDataJpa.entities.UserRelEntity;
import com.prac.springDataJpa.repositories.ProfileRelRepo;
import com.prac.springDataJpa.repositories.UserRelRepo;

@Service
public class UserRelServiceImpl {

	@Autowired
	UserRelRepo userRelRepo;
	
	@Autowired
	ProfileRelRepo profileRelRepo;

	public List<UserRelEntity> getAllUserRels() {

		List<UserRelEntity> userRelEntities = userRelRepo.findAll();

		return userRelEntities;
	}

	public void createUserRel(UserRelEntity userRelEntity) {

		userRelRepo.save(userRelEntity);
	}
	public void deleteUserRel(Integer id) {

		  userRelRepo.deleteById(id);
	}

	public void createProfileRel(ProfileRelEntity profileRelEntity) {

		profileRelRepo.save(profileRelEntity);
	}
	public void deleteProfileRel(Integer id) {

		profileRelRepo.deleteById(id);
	}

}
