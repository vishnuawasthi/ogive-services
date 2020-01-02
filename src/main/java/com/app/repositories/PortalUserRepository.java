package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.PortalUserDetails;

@Repository
public interface PortalUserRepository extends PagingAndSortingRepository<PortalUserDetails, Long> {

}
