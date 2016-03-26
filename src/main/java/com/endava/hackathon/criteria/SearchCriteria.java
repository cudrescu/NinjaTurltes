package com.endava.hackathon.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface SearchCriteria<T> {

	Predicate getPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder);
}
