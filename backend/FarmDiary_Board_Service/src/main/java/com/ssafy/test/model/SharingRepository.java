package com.ssafy.test.model;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SharingRepository extends PagingAndSortingRepository<Sharing, String>, CustomRepository{

}
