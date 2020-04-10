package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.PersonalTrainingDetails;

public interface PersonalTrainingDetailsRepository extends PagingAndSortingRepository<PersonalTrainingDetails, Long> {
}
