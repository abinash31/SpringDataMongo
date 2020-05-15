package com.justin.cruddemo.controllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin.cruddemo.controller.CustomerController;
import com.justin.cruddemo.models.Customer;
import com.justin.cruddemo.service.CustomerService;


@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	private List<Customer> customerList;
	
	private Customer customer;
	 
	 @BeforeEach
	    void setUp() {  
		 this.customerList = new ArrayList<Customer>();
		 this.customerList.add(new Customer("Bruce", "Wayne"));
		 this.customerList.add(new Customer("Alex", "Godman"));
		 this.customerList.add(new Customer("Tony", "Stark"));
		 
		 customer= new Customer("1","Zen", "John");
		 
	 }
	@Test
	public void getAllCustomerTest() throws Exception {
				        
        when(customerService.getAllCustomer()).thenReturn(customerList);
        
        this.mockMvc.perform(get("/customer/")).andExpect(status().isOk()).andExpect(jsonPath("$.size()", is(customerList.size())));
	}
	
	@Test
	public void updateCustomer() throws Exception {
		String json = objectMapper.writeValueAsString(customer);
        
		MvcResult result = 
        this.mockMvc.perform(post("/customer/").contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
        
		int status = result.getResponse().getStatus();
		System.out.println(status);
	}

}
