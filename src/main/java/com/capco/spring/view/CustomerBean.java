package com.capco.spring.view;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.capco.spring.entity.Customer;
import com.capco.spring.service.CustomerService;

@Component
@Scope(value="request")
public class CustomerBean implements Serializable{
	
	@Autowired
	private CustomerService customerService;
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}
	
}
