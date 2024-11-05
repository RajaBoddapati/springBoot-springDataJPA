package com.prac.springDataJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.springDataJpa.entities.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

}
