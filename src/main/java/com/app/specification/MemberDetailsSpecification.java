package com.app.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.app.entities.MemberDetails;
import com.app.filter.criteria.MemberSearchCriteria;

public class MemberDetailsSpecification implements Specification<MemberDetails> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberSearchCriteria getMemberSearchCriteria() {
		return memberSearchCriteria;
	}

	public void setMemberSearchCriteria(MemberSearchCriteria memberSearchCriteria) {
		this.memberSearchCriteria = memberSearchCriteria;
	}

	private MemberSearchCriteria memberSearchCriteria;

	public MemberDetailsSpecification(MemberSearchCriteria memberSearchCriteria) {
		this.memberSearchCriteria = memberSearchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<MemberDetails> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		List<Predicate> predicates = new ArrayList<>();

		if (Objects.nonNull(memberSearchCriteria.getMemberId())) {

			Predicate memberIdPredicate = criteriaBuilder.equal(root.get("id"), memberSearchCriteria.getMemberId());
			predicates.add(memberIdPredicate);
		}
		if (!StringUtils.isEmpty(memberSearchCriteria.getFirstName())) {
			Predicate firstNamePredicate = criteriaBuilder.equal(root.get("firstName"),
					memberSearchCriteria.getFirstName());
			predicates.add(firstNamePredicate);
		}

		if (!StringUtils.isEmpty(memberSearchCriteria.getLastName())) {
			Predicate lastNamePredicate = criteriaBuilder.equal(root.get("lastName"),
					memberSearchCriteria.getLastName());
			predicates.add(lastNamePredicate);
		}

		if (!StringUtils.isEmpty(memberSearchCriteria.getEmail())) {
			Predicate emailPredicate = criteriaBuilder.equal(root.get("email"), memberSearchCriteria.getEmail());
			predicates.add(emailPredicate);
		}

		if (!StringUtils.isEmpty(memberSearchCriteria.getMobileNumber())) {
			Predicate mobileNumberPredicate = criteriaBuilder.equal(root.get("mobileNumber"),
					memberSearchCriteria.getMobileNumber());
			predicates.add(mobileNumberPredicate);
		}

		if (!CollectionUtils.isEmpty(predicates)) {
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		}

		return null;
	}

}
