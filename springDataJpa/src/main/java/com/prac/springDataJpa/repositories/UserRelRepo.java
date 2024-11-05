package com.prac.springDataJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.springDataJpa.entities.UserRelEntity;

public interface UserRelRepo extends JpaRepository<UserRelEntity, Integer> {

}
