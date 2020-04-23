package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.CheckPayment;

public interface CheckPaymentRepository  extends PagingAndSortingRepository<CheckPayment, Long>{

}
