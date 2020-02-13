package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.UserAuthority;

public interface UserAuthoritiesRepository extends PagingAndSortingRepository<UserAuthority, Long> {

}
