package com.justin.cruddemo.serviceTest;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.justin.cruddemo.CustomerRepo.CustomerRepository;
import com.justin.cruddemo.models.Customer;
import com.justin.cruddemo.service.CustomerService;

@WebMvcTest(value = CustomerService.class)
public class CustomerServiceTest {

	@InjectMocks
    Customer customer;
     
    @Mock
    CustomerRepository customerRepo;
 
  
}
