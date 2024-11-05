package com.prac.springDataJpa.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.prac.springDataJpa.entities.EmployeeOfCompanyEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeOfCompanyEntity, Integer> {
	
	//Custom method
	EmployeeOfCompanyEntity findByEName(String employeeName);
	
	//Custom method
	List<EmployeeOfCompanyEntity> findByLocation(String location);
	
	//Custom Query
	@Query("select e from EmployeeOfCompanyEntity e where e.eSalary >:salary")
	List<EmployeeOfCompanyEntity> findEmployeesSalaryGreaterThan(@Param("salary") int sal);
	
	//Custom Query
	@Query("select e from EmployeeOfCompanyEntity e where e.eSalary <:salary")
	List<EmployeeOfCompanyEntity> findEmployeesSalaryLessThan(@Param("salary") int sal);
	
	//This method will be used by Named Query mentioned on EmployeeOfCompanyEntity Class
	List<EmployeeOfCompanyEntity> findEmpsByJoiningDate(@Param("date") LocalDate date);

}
