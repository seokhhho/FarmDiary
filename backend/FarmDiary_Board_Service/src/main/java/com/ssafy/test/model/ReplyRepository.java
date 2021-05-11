package com.ssafy.test.model;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReplyRepository extends PagingAndSortingRepository<Reply, String>, CustomRepository {

	List<Reply> findByBoardId(String boardId);
}
