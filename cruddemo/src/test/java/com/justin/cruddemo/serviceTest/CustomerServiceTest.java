package com.justin.cruddemo.serviceTest;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.justin.cruddemo.CustomerRepo.CustomerRepository;
import com.justin.cruddemo.models.Customer;

public class CustomerServiceTest {

	@InjectMocks
    Customer customer;
     
    @Mock
    CustomerRepository customerRepo;
 
  
}
