package com.justin.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.justin.cruddemo.models.Customer;
import com.justin.cruddemo.service.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PutMapping("/")
	public void addCustomer() {

		Customer customer = null;
		customerService.addCustomer(customer);

	}

	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public @ResponseBody Customer updateCustomer(@RequestBody Customer customer) {

		return customerService.updateCustomer(customer);
	}

	@DeleteMapping(path = "/{customernumber}", produces = "application/json")
	public @ResponseBody Customer deleteCustomer(@PathVariable("customernumber") String customerNumber) {

		return customerService.deleteCustomer(customerNumber);
	}

	@GetMapping(path = "/{customernumber}", produces = "application/json")
	public @ResponseBody Customer getCustomer(@PathVariable("customernumber") String customerNumber) {

		return customerService.getCustomer(customerNumber);
	}

	@GetMapping(path = "/", produces = "application/json")
	public @ResponseBody List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

}
