package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.AddressDetails;

public interface AddressDetailsRepository  extends PagingAndSortingRepository<AddressDetails, Long>{

}
