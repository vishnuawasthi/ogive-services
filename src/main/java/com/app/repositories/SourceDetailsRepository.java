package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.SourceDetails;

public interface SourceDetailsRepository extends PagingAndSortingRepository<SourceDetails, String> {

}
