package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.PersonalTrainingDetail;

public interface PersonalTrainingDetailsRepository extends PagingAndSortingRepository<PersonalTrainingDetail, Long> {
}
