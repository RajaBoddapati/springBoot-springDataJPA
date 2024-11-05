package com.prac.springDataJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.springDataJpa.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
