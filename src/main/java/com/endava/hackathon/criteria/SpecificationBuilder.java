package com.endava.hackathon.criteria;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SpecificationBuilder {

	public static <T> Specification<T> makeSearchSpecification(
			final List<SearchCriteria<T>> searchCriteria, final boolean isDistinct) {
		
		return new Specification<T>() {
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				query.distinct(isDistinct);
				List<Predicate> predicates = new ArrayList<Predicate>(searchCriteria.size());
				for (SearchCriteria<T> searchCriterion : searchCriteria) {
					Predicate predicate = searchCriterion.getPredicate(root, query, builder);
					if (predicate != null) {
						predicates.add(predicate);
					}
				}
				return builder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

}
