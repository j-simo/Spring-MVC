package com.capco.spring.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capco.spring.entity.Customer;
import com.capco.spring.service.CustomerService;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String listCustomers(ModelMap model) {
		List<Customer> allCustomers = customerService.getAllCustomers();
		model.put("customers", allCustomers);
		return "customers";
	}

	@RequestMapping(value="delete" , method = RequestMethod.GET)
	public String processDeleteCustomer(@RequestParam("id") long id) {
		customerService.deleteCustomer(id);
		return "redirect:/customers";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String showEditCustomer(@RequestParam(required=false, value="id") Long id, ModelMap model) {
		if (id == null) {
			model.put("customer", new Customer());
		} else {
			model.put("customer", customerService.getCustomerById(id));
		}
		return "customer-edit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processAddCustomer(@ModelAttribute("customer") @Valid Customer customer, Errors validationErrors) {
		if (validationErrors.hasErrors()) {
			return "customer-edit";
		}
		customerService.addCustomer(customer);
		return "redirect:/customers";
	}
	
	@RequestMapping(params="cancel", method = RequestMethod.POST)
	public String cancelSave() {
		return "redirect:/customers";
	}
}
