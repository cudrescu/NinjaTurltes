package com.endava.hackathon.criteria;

import com.endava.hackathon.model.UserEntity;

import javax.persistence.criteria.*;

public class UserLastNameSearchCriteria implements SearchCriteria<UserEntity> {
    private String lastName;

    public UserLastNameSearchCriteria(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Predicate getPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Path<String> userLastNamePath = root.get(UserEntity.LAST_NAME);
        return builder.like(userLastNamePath, this.lastName+"%");
    }
}
