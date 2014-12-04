package com.capco.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capco.spring.entity.Customer;
import com.capco.spring.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(ModelMap model) {
        List<Customer> allCustomers =  customerService.getAllCustomers();
        model.put("customers", allCustomers);
        return "customers";
    }
}
