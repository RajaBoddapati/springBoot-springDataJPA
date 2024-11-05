package com.prac.springDataJpa.servicesImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prac.springDataJpa.dtos.EmployeeOfCompanyDTO;
import com.prac.springDataJpa.entities.EmployeeOfCompanyEntity;
import com.prac.springDataJpa.repositories.EmployeePaginationAndSortingRepo;
import com.prac.springDataJpa.repositories.EmployeeRepo;
import com.prac.springDataJpa.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	EmployeePaginationAndSortingRepo pageAndSortRepo;
	
	@Override
	public List<EmployeeOfCompanyEntity> getAllEmployees(){
		
		List<EmployeeOfCompanyEntity> allEmployees= employeeRepo.findAll();
		return allEmployees;
	}
	
	@Override
	public EmployeeOfCompanyEntity createEmployee(EmployeeOfCompanyEntity employee) {
		if(employee==null) {
			throw new RuntimeException("Send correct data");
		}
		EmployeeOfCompanyEntity createdEmployee =  employeeRepo.save(employee);
		return createdEmployee;
	}
      
	@Override
	public void deleteAllEmployees() {
		
		employeeRepo.deleteAllInBatch();
	}
	
	@Override
	public boolean updateEmployee(int id,EmployeeOfCompanyEntity employee) {
		
		EmployeeOfCompanyEntity existedUser= employeeRepo.findById(id).get();
		if(existedUser==null) {
			throw new RuntimeException("User not found");
		}
		System.out.println(existedUser);
		existedUser.seteName(employee.geteName());
		existedUser.seteSalary(employee.geteSalary());
		existedUser.setJoinedDate(employee.getJoinedDate());
		//existedUser.setLocation(employee.getLocation());
		employeeRepo.save(existedUser);
		
		
		return true;
	}
	
	@Override
	public boolean updateEmployeeSalary(int id,EmployeeOfCompanyEntity employee) {
		
		EmployeeOfCompanyEntity existedUser= employeeRepo.findById(id).get();
		if(existedUser==null) {
			throw new RuntimeException("User not found");
		}
		System.out.println(existedUser);
		existedUser.seteSalary(employee.geteSalary());
		employeeRepo.save(existedUser);
		return true;
	}
	
	public EmployeeOfCompanyEntity findEmployeeByName(String name) {
		return employeeRepo.findByEName(name);
	}
	
	public List<EmployeeOfCompanyEntity> findEmployeesByLocation(String location) {
		return employeeRepo.findByLocation(location);
	}
	public List<EmployeeOfCompanyEntity> findEmployeesSalGreaterThan(int salary) {
		return employeeRepo.findEmployeesSalaryGreaterThan(salary);
	}
	
	//DTO are useful when we want to expose only specific attributes of Entity Objects
	public List<EmployeeOfCompanyDTO> findEmployeesSalLesserThan(int salary) {
		List<EmployeeOfCompanyDTO> employeesDTO = new ArrayList<EmployeeOfCompanyDTO>();
		List<EmployeeOfCompanyEntity> employessEntity= employeeRepo.findEmployeesSalaryLessThan(salary);
		employessEntity.stream().map(entity->{
			EmployeeOfCompanyDTO dto = new EmployeeOfCompanyDTO();
			dto.seteName(entity.geteName());
			dto.seteSalary(entity.geteSalary());
            dto.setLocation(entity.getLocation());
			return employeesDTO.add(dto);

		}).collect(Collectors.toList());
		
		System.out.println("employeesDTO :"+employeesDTO);
		
		return employeesDTO;
	}
	
	public List<EmployeeOfCompanyEntity> retrieveEmployeesByJoiningDate(LocalDate date) {
		return employeeRepo.findEmpsByJoiningDate(date);
	}
	
	//Pagination and Sorting 
	public Page<EmployeeOfCompanyEntity> getEmployees(int page,int size){
		
		PageRequest pageRequest = PageRequest.of(page, size,Sort.by("eSalary"));
		return pageAndSortRepo.findAll(pageRequest);
	}
	
}
