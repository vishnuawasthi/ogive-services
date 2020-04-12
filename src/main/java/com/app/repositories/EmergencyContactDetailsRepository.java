package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.EmergencyContactDetails;

public interface EmergencyContactDetailsRepository extends PagingAndSortingRepository<EmergencyContactDetails, Long> {

}
