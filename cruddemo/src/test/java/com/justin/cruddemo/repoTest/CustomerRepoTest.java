package com.justin.cruddemo.repoTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.justin.cruddemo.CustomerRepo.CustomerRepository;
import com.justin.cruddemo.models.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepoTest {

	@Autowired
	private CustomerRepository userRepository;

	 @Test
	  public void saveTest() {
	    Customer user = new Customer("Tom","Pain");
	    user =userRepository.save(user);
	    Assert.assertNotNull(userRepository.findById(user.id));
	  }

}
