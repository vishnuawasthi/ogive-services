package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.StaffDetails;

public interface StaffDetailsRepository extends PagingAndSortingRepository<StaffDetails, Long> {

}
