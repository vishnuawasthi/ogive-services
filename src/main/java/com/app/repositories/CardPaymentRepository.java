package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.CardPayment;

public interface CardPaymentRepository extends PagingAndSortingRepository<CardPayment, Long> {

}
