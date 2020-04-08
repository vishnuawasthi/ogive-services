package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.ProspectDetails;

public interface ProspectDetailsRepository extends PagingAndSortingRepository<ProspectDetails, Long> {

}
