package com.endava.hackathon.criteria;

import com.endava.hackathon.model.UserEntity;

import javax.persistence.criteria.*;

public class UserEmailSearchCriteria implements SearchCriteria<UserEntity> {

    private String email;

    public UserEmailSearchCriteria(String email) {
        this.email = email;
    }

    @Override
    public Predicate getPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Path<String> userEmailPath = root.get(UserEntity.EMAIL);
        return builder.like(userEmailPath, this.email+"%");
    }

}
