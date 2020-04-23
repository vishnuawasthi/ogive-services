package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.CashPayment;

public interface CashPaymentRepository extends PagingAndSortingRepository<CashPayment, Long> {

}
