package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.app.entities.CountryDetails;

public interface CountryDetailsRepository extends PagingAndSortingRepository<CountryDetails, Long> {

	CountryDetails findCountryDetailsByCountryCodeIgnoreCase(@Param(value="countryCode") String countryCode);
	
	@Query("SELECT c.id,c.countryName,c.countryCode,c.nationality FROM CountryDetails c ")
	List<Object[]> findAllCountries();
	
}
