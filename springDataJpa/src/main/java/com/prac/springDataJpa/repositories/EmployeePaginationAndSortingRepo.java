package com.prac.springDataJpa.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prac.springDataJpa.entities.EmployeeOfCompanyEntity;

public interface EmployeePaginationAndSortingRepo extends PagingAndSortingRepository<EmployeeOfCompanyEntity,Integer> {

}
