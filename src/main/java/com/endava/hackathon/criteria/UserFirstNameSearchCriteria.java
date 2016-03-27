package com.endava.hackathon.criteria;

import com.endava.hackathon.model.ProfileEntity;
import com.endava.hackathon.model.UserEntity;

import javax.persistence.criteria.*;

public class UserFirstNameSearchCriteria implements SearchCriteria<UserEntity> {

    private String firstName;

    public UserFirstNameSearchCriteria(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public Predicate getPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Path<String> userFirstNamePath = root.get(UserEntity.PROFILE).get(ProfileEntity.FIRST_NAME);
        return builder.like(userFirstNamePath, this.firstName+"%");
    }
}
