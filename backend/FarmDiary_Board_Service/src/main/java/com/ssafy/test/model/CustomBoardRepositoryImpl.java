package com.ssafy.test.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CustomBoardRepositoryImpl implements CustomBoardRepository{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
}
