package com.prac.springDataJpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prac.springDataJpa.dtos.CustomerDTO;
import com.prac.springDataJpa.servicesImpl.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/customers")
	public List<CustomerDTO> getAllCustomers(){
		return customerServiceImpl.getAllCustomers();
		
	}
	
	@PostMapping("/customers")
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
		customerServiceImpl.createCustomer(customerDTO);
		return new ResponseEntity<CustomerDTO>(HttpStatus.CREATED);
		
	}
	@GetMapping("/customers/debit/from/{fromcid}/credit/to/{tocid}/amount/{amount}")
	public boolean debitFromOneCustomerAndCreditToOtherCustomer(@PathVariable int fromcid,@PathVariable int tocid,@PathVariable Double amount) {
		
		
		return customerServiceImpl.debitFromOneCustomerAndCreditToOtherCustomer(fromcid,tocid,amount);
	}

}
