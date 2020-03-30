package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.MembershipDetails;

public interface MembershipDetailsRepository extends PagingAndSortingRepository<MembershipDetails, Long> {

}
