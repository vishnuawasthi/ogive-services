package com.app.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.constants.MembershipTypeStatus;
import com.app.entities.MembershipType;

// https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-seven-pagination/
public interface MembershipTypeRepository extends PagingAndSortingRepository<MembershipType, Long> {

	//Page<MembershipTypes> findByMembershipTypeCodeAllIgnoreCase(String membershipTypeCode, Pageable pageRequest);
	
	@Query(value="UPDATE MembershipType mbrshipType SET mbrshipType.status =:status WHERE mbrshipType.id =:id")
	void suspendMembershipType(Long id,String status);
	
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE MembershipType mbrshipType SET mbrshipType.status =:status WHERE mbrshipType.id =:id")
	void updateMembershipTypeStatus(Long id,MembershipTypeStatus status);
	
}
