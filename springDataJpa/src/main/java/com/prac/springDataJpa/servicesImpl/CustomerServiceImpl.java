package com.prac.springDataJpa.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.springDataJpa.dtos.CustomerDTO;
import com.prac.springDataJpa.entities.CustomerEntity;
import com.prac.springDataJpa.repositories.CustomerRepo;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl {
	
	@Autowired
	CustomerRepo customerRepo;
	
    public List<CustomerDTO> getAllCustomers(){
    	
    	List<CustomerEntity> customerEntities =  customerRepo.findAll();
    	List<CustomerDTO> customerDtos = new ArrayList<CustomerDTO>();
    	
    	//Do this using bean mappers instead of manually setting
    	customerEntities.stream().forEach(e->{
    		CustomerDTO dto = new CustomerDTO();
    		dto.setcId(e.getcId());
    		dto.setcName(e.getcName());
    		dto.setAccountNum(e.getAccountNum());
    		dto.setBranch(e.getBranch());
    		dto.setBalance(e.getBalance());
    		dto.setLoanAmount(e.getLoanAmount());
    		customerDtos.add(dto);
    	});
    	
    	return customerDtos;
    }
    
    public void createCustomer(CustomerDTO customerDTO) {
    	
    	CustomerEntity entity = new CustomerEntity();
    	entity.setcId(customerDTO.getcId());
    	entity.setcName(customerDTO.getcName());
    	entity.setAccountNum(customerDTO.getAccountNum());
    	entity.setBranch(customerDTO.getBranch());
    	entity.setBalance(customerDTO.getBalance());
    	entity.setLoanAmount(customerDTO.getLoanAmount());
    	customerRepo.save(entity);
    }
    
    
    /*There are 4 propagation types for @Transactional
     * 1)@Transactional(propagation=Propagation.REQUIRED) : REQUIRED is default Propagation
     * 2)@Transactional(propagation=Propagation.REQUIRED_NEW)
     * 3)@Transactional(propagation=Propagation.SUPPORTS)
     * 4)@Transactional(propagation=Propagation.NESTED)
     * */
    @Transactional
    public boolean debitFromOneCustomerAndCreditToOtherCustomer(int fromcid,int tocid,Double amount) {
    	CustomerEntity fromCustomerEntity = customerRepo.findById(fromcid).orElse(null);
    	CustomerEntity toCustomerEntity = customerRepo.findById(tocid).orElse(null);
    	if(fromCustomerEntity==null) {
    		throw new RuntimeException("From Customer Not Found");
    	}
    	fromCustomerEntity.setBalance(fromCustomerEntity.getBalance()-amount);
    	customerRepo.save(fromCustomerEntity);
    	
    	if(toCustomerEntity==null) {
    		throw new RuntimeException("To Customer Not Found");
    	}
    	toCustomerEntity.setBalance(toCustomerEntity.getBalance()+amount);
    	customerRepo.save(toCustomerEntity);
    	
    	return true;
    }

}
