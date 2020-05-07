package com.app.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.MemberDetails;

public interface MemberDetailsRepository  extends PagingAndSortingRepository<MemberDetails, Long>,JpaSpecificationExecutor<MemberDetails> {

}
