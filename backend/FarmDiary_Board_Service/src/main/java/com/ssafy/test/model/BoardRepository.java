package com.ssafy.test.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ssafy.test.Customer;

public interface BoardRepository extends PagingAndSortingRepository<Board, String>, CustomBoardRepository {
	
}
