package com.app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.MembershipTypes;

// https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-seven-pagination/
public interface MembershipTypeRepository extends PagingAndSortingRepository<MembershipTypes, Long> {

	//Page<MembershipTypes> findByMembershipTypeCodeAllIgnoreCase(String membershipTypeCode, Pageable pageRequest);
}
