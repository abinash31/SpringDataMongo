package com.justin.cruddemo.CustomerRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.justin.cruddemo.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	  public Customer findByFirstName(String firstName);
	  public Customer findByLastName(String lastName);

	}
