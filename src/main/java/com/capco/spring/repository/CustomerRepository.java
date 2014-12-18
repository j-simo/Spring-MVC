package com.capco.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capco.spring.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	public Customer getCustomerByFirstName(String firstName);
}
