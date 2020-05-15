package com.justin.cruddemo.service;

import java.util.List;

import com.justin.cruddemo.models.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer) ;

	public Customer deleteCustomer(String id) ;
	
	public Customer getCustomer(String id) ;
	
	public List<Customer> getAllCustomer() ;

}
