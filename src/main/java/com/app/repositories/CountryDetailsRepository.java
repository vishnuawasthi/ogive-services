package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.app.entities.CountryDetails;

public interface CountryDetailsRepository extends PagingAndSortingRepository<CountryDetails, Long> {

	CountryDetails findCountryDetailsByCountryCodeIgnoreCase(@Param(value="countryCode") String countryCode);
}
