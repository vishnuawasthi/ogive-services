package com.app.services;

import java.util.Date;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.constants.PaymentTypes;
import com.app.dto.CreatePaymentRequest;
import com.app.dto.MembershipPaymentDetailResponse;
import com.app.entities.CardPayment;
import com.app.entities.CashPayment;
import com.app.entities.CheckPayment;
import com.app.entities.MembershipPaymentDetailsView;
import com.app.entities.PaymentDetails;
import com.app.repositories.CardPaymentRepository;
import com.app.repositories.CashPaymentRepository;
import com.app.repositories.CheckPaymentRepository;
import com.app.repositories.MembershipPaymentDetailsViewRepository;
import com.app.utils.CommonUtils;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	private CheckPaymentRepository checkPaymentRepository;

	@Autowired
	private CashPaymentRepository cashPaymentRepository;

	@Autowired
	private CardPaymentRepository cardPaymentRepository;
	
	@Autowired
	private MembershipPaymentDetailsViewRepository membershipPaymentDetailsViewRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void savePaymentDetails(CreatePaymentRequest request) {
		log.info("savePaymentDetails() - start");

		request.getPayments().forEach(paymentReq -> {

			if (PaymentTypes.CASH.equals(paymentReq.getPaymentType())) {

				CashPayment cashPayment = new CashPayment();
				cashPayment.setAmount(paymentReq.getAmount());
				setAuditDetails(cashPayment, request);
				cashPaymentRepository.save(cashPayment);

			}

			if (PaymentTypes.CARD.equals(paymentReq.getPaymentType())) {
				CardPayment cardPayment = new CardPayment();
				cardPayment.setAmount(paymentReq.getAmount());
				cardPayment.setCardNumber(paymentReq.getCardNumber());
				setAuditDetails(cardPayment, request);
				cardPaymentRepository.save(cardPayment);
			}

			if (PaymentTypes.CHECK.equals(paymentReq.getPaymentType())) {

				CheckPayment checkPayment = new CheckPayment();
				checkPayment.setCheckNumber(paymentReq.getCheckNumber());
				checkPayment.setAmount(paymentReq.getAmount());
				checkPayment.setCheckDate(paymentReq.getCheckDate());
				checkPayment.setBank(paymentReq.getBank());
				setAuditDetails(checkPayment, request);
				checkPaymentRepository.save(checkPayment);
			}
		});

		log.info("savePaymentDetails() - end");
	}

	private void setAuditDetails(PaymentDetails payment, CreatePaymentRequest request) {
		Date paymentTime = new Date();
		payment.setCreatedDate(paymentTime);
		payment.setUpatedDate(paymentTime);
		payment.setCreatedBy(CommonUtils.getCurrentUser());
		payment.setUpdatedBy(CommonUtils.getCurrentUser());

		payment.setMemberId(request.getMemberId());
		payment.setMembershipId(request.getMembershipId());
	}

	@Override
	public MembershipPaymentDetailResponse fetchPaymentDetails(Long membershipId) {
		log.info("fetchPaymentDetails() - start");
		MembershipPaymentDetailResponse paymentDetailsResponse = null;

		MembershipPaymentDetailsView entity = membershipPaymentDetailsViewRepository.findByMembershipId(membershipId);

		if (Objects.nonNull(entity)) {
			paymentDetailsResponse = new MembershipPaymentDetailResponse();
			BeanUtils.copyProperties(entity, paymentDetailsResponse);
		}

		log.info("fetchPaymentDetails() - end");
		return paymentDetailsResponse;
	}
	
	
}
