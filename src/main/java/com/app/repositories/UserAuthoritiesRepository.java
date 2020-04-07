package com.app.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.PortalUserDetails;
import com.app.entities.UserAuthority;

public interface UserAuthoritiesRepository extends PagingAndSortingRepository<UserAuthority, Long> {

	List<UserAuthority> findAllByPortalUserDetails(PortalUserDetails portalUserDetails);
	
}
