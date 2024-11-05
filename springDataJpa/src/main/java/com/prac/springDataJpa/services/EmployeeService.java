package com.prac.springDataJpa.services;

import java.util.List;

import com.prac.springDataJpa.entities.EmployeeOfCompanyEntity;

public interface EmployeeService {

	public List<EmployeeOfCompanyEntity> getAllEmployees();
	public EmployeeOfCompanyEntity createEmployee(EmployeeOfCompanyEntity employee);
	public void deleteAllEmployees();
	public boolean updateEmployee(int id,EmployeeOfCompanyEntity employee);
	public boolean updateEmployeeSalary(int id,EmployeeOfCompanyEntity employee);
}
