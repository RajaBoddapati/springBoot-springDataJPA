package com.prac.springDataJpa.controllers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prac.springDataJpa.dtos.EmployeeOfCompanyDTO;
import com.prac.springDataJpa.entities.EmployeeOfCompanyEntity;
import com.prac.springDataJpa.servicesImpl.EmployeeServiceImpl;

//This controller is for EmployeeOfCompany

@RestController
public class Controller2 {
	
	@Autowired
	EmployeeServiceImpl  employeeServiceImpl;

	@GetMapping("/employees")
	public List<EmployeeOfCompanyEntity> getAllEmployees() {
		
		return employeeServiceImpl.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public ResponseEntity<EmployeeOfCompanyEntity> addEmployee(@RequestBody EmployeeOfCompanyEntity employee) {
		
		EmployeeOfCompanyEntity createdEmployee = employeeServiceImpl.createEmployee(employee);
		return new ResponseEntity<EmployeeOfCompanyEntity>(createdEmployee,HttpStatus.CREATED);
		//return new ResponseEntity<EmployeeOfCompany>(HttpStatus.CREATED);
		
		
	}
	@DeleteMapping("/employees")
	public void removeAllEmployees() {
		
		employeeServiceImpl.deleteAllEmployees();
		
	}
	@PutMapping("/employees/{id}")
	public boolean updateEmployee(@PathVariable int id,@RequestBody EmployeeOfCompanyEntity employee) {
		
		return employeeServiceImpl.updateEmployee(id,employee);
		
	}
	@PatchMapping("/employees/{id}")
	public boolean updateEmployeeSalary(@PathVariable int id,@RequestBody EmployeeOfCompanyEntity employee) {
		
		return employeeServiceImpl.updateEmployeeSalary(id,employee);
		
	}
	
	@GetMapping("/employees-name/{name}")
	public EmployeeOfCompanyEntity getEmployeeByName(@PathVariable String name) {
		return employeeServiceImpl.findEmployeeByName(name);
		
	}
	@GetMapping("/employees-location/{location}")
	public List<EmployeeOfCompanyEntity> getEmployeesByLocation(@PathVariable String location) {
		return employeeServiceImpl.findEmployeesByLocation(location);
		
	}
	@GetMapping("/employees-sal-greater/{salary}")
	public List<EmployeeOfCompanyEntity> getEmployeesSalGreaterThan(@PathVariable int salary) {
		return employeeServiceImpl.findEmployeesSalGreaterThan(salary);
		
	}
	@GetMapping("/employees-sal-less/{salary}")
	public List<EmployeeOfCompanyDTO> getEmployeesSalLesserThan(@PathVariable int salary) {
		return employeeServiceImpl.findEmployeesSalLesserThan(salary);
		
	}
	@GetMapping("/employees-by-joinedDate/{date}")
	public List<EmployeeOfCompanyEntity> getEmployeesByJoinedDate(@PathVariable String date) {
		String dateArr[] = date.split("-");
		//Arrays.stream(dateArr).forEach(System.out::println);
		int year =Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]);
		int dat = Integer.parseInt(dateArr[2]);
		LocalDate ld = LocalDate.of(year,month,dat);
		return employeeServiceImpl.retrieveEmployeesByJoiningDate(ld);
		
	}
	
	//http://localhost:8080/employees-by-paginationAndSorting?pageNo=0&size=3
	@GetMapping("/employees-by-paginationAndSorting")
	public Page<EmployeeOfCompanyEntity> getEmployeesByPaginationAndSorting(@RequestParam int pageNo,@RequestParam int size) {
		return employeeServiceImpl.getEmployees(pageNo, size);
		
	}
	
	
}
