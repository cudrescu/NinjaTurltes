package com.endava.hackathon.criteria;

import com.endava.hackathon.model.ProfileEntity;
import com.endava.hackathon.model.UserEntity;
import com.endava.hackathon.model.UserPositionEntity;

import javax.persistence.criteria.*;

public class UserPositionSearchCriteria implements SearchCriteria<UserEntity> {

    private String position;

    public UserPositionSearchCriteria(String position){
        this.position = position;
    }

    @Override
    public Predicate getPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Path<String> userPositionPath = root.get(UserEntity.PROFILE).get(ProfileEntity.POSITION).get(UserPositionEntity.NAME);
        return builder.like(userPositionPath, this.position+"%");
    }
}
