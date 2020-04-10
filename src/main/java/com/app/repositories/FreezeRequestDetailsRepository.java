package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.FreezeRequestDetails;

public interface FreezeRequestDetailsRepository   extends PagingAndSortingRepository<FreezeRequestDetails, Long>{

}
