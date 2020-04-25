package com.app.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.PersonalTrainingDetailView;

public interface PersonalTrainingDetailViewRepository
		extends PagingAndSortingRepository<PersonalTrainingDetailView, Long> {

	List<PersonalTrainingDetailView> findAllPersonalTrainingDetailViewByMemberIdOrderByStartDateDesc(Long memberId);
	
	PersonalTrainingDetailView findPersonalTrainingDetailViewByMemberIdAndId(Long memberId, Long id);

}
