package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.PortalUserDetails;

public interface PortalUserRepository extends PagingAndSortingRepository<PortalUserDetails, Long> {

	PortalUserDetails findByUsername(String username);
}
