package com.app.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.app.entities.MemberDetails;
import com.app.entities.MembershipDetails;
import com.app.filter.criteria.MembershipFilterCriteria;

public class MembershipDetailsSpecification implements Specification<MembershipDetails> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MembershipFilterCriteria filter;

	public MembershipDetailsSpecification(MembershipFilterCriteria filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<MembershipDetails> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();

		if (Objects.nonNull(filter)) {

			Join<MembershipDetails, MemberDetails> mbrshipMemberJoin = root.join("memberDetails");

			if (Objects.nonNull(filter.getMemberId())) {

				Predicate memberIdPredicate = criteriaBuilder.equal(mbrshipMemberJoin.get("id"), filter.getMemberId());
				predicates.add(memberIdPredicate);
			}

			if (Objects.nonNull(filter.getMembershipId())) {
				Predicate predicateOnMembershipId = criteriaBuilder.equal(root.get("id"), filter.getMembershipId());
				predicates.add(predicateOnMembershipId);
			}

			if (!StringUtils.isEmpty(filter.getFirstName())) {
				Predicate firstNamePredicate = criteriaBuilder.equal(mbrshipMemberJoin.get("firstName"),
						filter.getFieldName());
				predicates.add(firstNamePredicate);
			}

			if (!StringUtils.isEmpty(filter.getLastName())) {
				Predicate lastNamePredicate = criteriaBuilder.equal(mbrshipMemberJoin.get("lastName"),
						filter.getLastName());
				predicates.add(lastNamePredicate);
			}

			if(!StringUtils.isEmpty(filter.getFieldName())) {
				
				if(!StringUtils.isEmpty(filter.getSortOrder()) && ("DESC".equalsIgnoreCase(filter.getSortOrder()) || "DESCENDING".equalsIgnoreCase(filter.getSortOrder())) ) {
					query.orderBy(criteriaBuilder.desc(root.get(filter.getFieldName())));
				}else {
					query.orderBy(criteriaBuilder.asc(root.get(filter.getFieldName())));
				}
			}else {
				query.orderBy(criteriaBuilder.asc(root.get("id")));
			}

			if (!CollectionUtils.isEmpty(predicates)) {
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}
		return null;
	}

}
