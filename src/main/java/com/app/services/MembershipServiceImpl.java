package com.app.services;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CreateMembershipTypeRequest;
import com.app.dto.MembershipTypeResponse;
import com.app.entities.MembershipTypes;
import com.app.exception.RecordNotFoundException;
import com.app.repositories.MembershipTypeRepository;

@Service
public class MembershipServiceImpl implements MembershipService {

	private static final Logger log = Logger.getLogger(MembershipServiceImpl.class);

	@Autowired
	private MembershipTypeRepository membershipTypeRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createMembershipType(CreateMembershipTypeRequest createMembershipTypeRequest) {
		log.info("createMembershipType() - start");
		MembershipTypes entity = new MembershipTypes();
		BeanUtils.copyProperties(createMembershipTypeRequest, entity);
		log.info("entity -> " + entity);
		System.out.println("entity ->" + entity);
		membershipTypeRepository.save(entity);
		log.info("createMembershipType() - end");
		return entity.getId();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MembershipTypeResponse updateMembershipType(Long id,
			CreateMembershipTypeRequest createMembershipTypeRequest) {
		log.info("updateMembershipType() - start");
		MembershipTypes entity = membershipTypeRepository.findById(id).orElse(null);
		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No such record exist with given id " + id);
		}
		log.info("updateMembershipType() - end");
		return null;
	}

	@Override
	public MembershipTypeResponse getMembershipTypeById(Long id) {
		log.info("getMembershipTypeById() - start");
		MembershipTypes entity = membershipTypeRepository.findById(id).orElse(null);
		MembershipTypeResponse responseObject = null;

		if (Objects.nonNull(entity)) {
			responseObject = new MembershipTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}
		log.info("getMembershipTypeById() - start");
		return responseObject;
	}

	@Override
	public Page<MembershipTypeResponse> getAllMembershipTypes(String membershipTypeCode, Pageable pageRequest) {
		log.info("getMembershipTypeById() - start");

		Page<MembershipTypes> pagedMembershipData = membershipTypeRepository
				.findByMembershipTypeCodeAllIgnoreCase(membershipTypeCode, pageRequest);

		Page<MembershipTypeResponse> dtoPage = pagedMembershipData.map(entity -> {
			MembershipTypeResponse responseObject = new MembershipTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);
			return responseObject;
		});

		log.info("getAllMembershipTypes() - end");
		return dtoPage;
	}

}
