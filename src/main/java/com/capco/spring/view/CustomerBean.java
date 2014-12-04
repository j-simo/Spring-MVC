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

	private Long id;
	
	private String firstName;
	
	private String secondName;
	
	private String address;
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}
	
	 public String showEditCustomer() {
	        Customer customer = customerService.getCustomerById(id);
	        id = customer.getId();
	        firstName = customer.getFirstName();
	        secondName = customer.getLastName();
	        address = customer.getAddress();
	        return "edit-customer";
	    }
	
	 public String deleteCustomer() {
	        Customer customer = customerService.getCustomerById(id);
	        customerService.deleteCustomer(id);
	        return "customers?faces-redirect=true";
	    }
}
