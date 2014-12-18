package com.capco.spring.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capco.spring.entity.Customer;
import com.capco.spring.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService implements Serializable{
	
	@Autowired
	private transient CustomerRepository customerDao;
	
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerDao.findAll();
	}
	
	public Customer getCustomerById(Long id) {
		return customerDao.findOne(id);
	}
	
	public void deleteCustomer(Long id) {
		customerDao.delete(id);
	}
	
	public void addCustomer(Customer customer) {
		customerDao.save(customer);
	}
}
