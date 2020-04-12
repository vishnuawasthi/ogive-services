package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.BusinessUnitDetails;

public interface BusinessUnitDetailsRepository extends PagingAndSortingRepository<BusinessUnitDetails, Long> {

	@Query("SELECT bu.id, bu.businessUnitCode, bu.businessUnitName FROM BusinessUnitDetails bu ")
	List<Object[]> loadAllBusinessUnits();

}
