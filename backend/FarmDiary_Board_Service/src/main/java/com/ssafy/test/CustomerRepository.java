package com.ssafy.test;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	public List<Customer> findByFirstName(String firstName);
}
