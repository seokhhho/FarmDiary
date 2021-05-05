package com.ssafy.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		Customer customer1 = new Customer("son", "changwoo");
		Customer customer2 = new Customer("son", "jeehoon");
		
		customerRepository.insert(Arrays.asList(customer1,customer2));
		
		List<Customer> result = customerRepository.findByFirstName("son");
		System.out.println(result);
		
	}
}
