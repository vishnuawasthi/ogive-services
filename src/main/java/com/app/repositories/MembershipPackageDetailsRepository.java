package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.PackageDetails;

public interface MembershipPackageDetailsRepository extends PagingAndSortingRepository<PackageDetails, Long> {

}
