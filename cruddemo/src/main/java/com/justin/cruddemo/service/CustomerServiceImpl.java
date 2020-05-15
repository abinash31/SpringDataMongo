package com.justin.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.cruddemo.CustomerRepo.CustomerRepository;
import com.justin.cruddemo.models.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public void addCustomer(Customer customer) {

		System.out.println("[add Customer Service]");

		if (customer != null) {
			repository.save(customer);
		} else {
			repository.save(new Customer("Bruce", "Wayne"));
			repository.save(new Customer("Alex", "Godman"));
			repository.save(new Customer("Tony", "Stark"));

		}

	}

	@Override
	public Customer updateCustomer(Customer customer) {

		Customer dbcustomer = null;
		Optional<Customer> customerList = repository.findById(customer.getId());
		if (customerList.isPresent()) {
			dbcustomer = customerList.get();
			dbcustomer.setFirstName(customer.getFirstName());
			dbcustomer.setLastName(customer.getLastName());
			customer = repository.save(dbcustomer);
		} else {
			dbcustomer = repository.findByFirstName(customer.getFirstName());
			if (dbcustomer != null) {
				dbcustomer.setLastName(customer.getLastName());
				customer = repository.save(dbcustomer);
			} else {
				dbcustomer = repository.findByLastName(customer.getLastName());
				if (dbcustomer != null) {
					dbcustomer.setFirstName(customer.getFirstName());
					customer = repository.save(dbcustomer);
				}
			}
		}

		return customer;

	}

	@Override
	public Customer deleteCustomer(String id) {

		Optional<Customer> customerList = repository.findById(id);
		Customer customer = null;
		if (customerList.isPresent()) {
			customer = customerList.get();
			repository.delete(customer);
		}
		return customer;
	}

	@Override
	public Customer getCustomer(String id) {
		// fetch an individual customer
		Optional<Customer> customerList = repository.findById(id);
		Customer customer = null;
		if (customerList.isPresent()) {
			customer = customerList.get();
		}
		return customer;

	}

	@Override
	public List<Customer> getAllCustomer() {

		// fetch all customers
		List<Customer> customerList = repository.findAll();
		return customerList;
	}

}
