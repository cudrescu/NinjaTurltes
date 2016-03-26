package com.endava.hackathon.service.impl;

import com.endava.hackathon.criteria.*;
import com.endava.hackathon.dto.ProfileFilter;
import com.endava.hackathon.dto.UserProfile;
import com.endava.hackathon.exceptions.UserNotFoundException;
import com.endava.hackathon.model.UserEntity;
import com.endava.hackathon.repository.UserRepository;
import com.endava.hackathon.service.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserProfile getUserProfile(String email) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null) {
            throw new UserNotFoundException("User with email " + email + " doesn't exist");
        }
        return mapper.map(userEntity, UserProfile.class);
    }

    @Override
    public List<UserProfile> searchUserProfiles(ProfileFilter profileFilter) {

        List<SearchCriteria<UserEntity>> searchCriteria = buildSearchCriteria(profileFilter);
        final Pageable pageable = new PageRequest(profileFilter.getPageNumber()-1, profileFilter.getPageSize());

        List<UserProfile> userProfiles = Collections.emptyList();
        Specification<UserEntity> specification = null;
        if(searchCriteria != null && !searchCriteria.isEmpty()){
            specification = SpecificationBuilder.makeSearchSpecification(searchCriteria, false);
        }
        Page<UserEntity> userEntityPage = userRepository.findAll(specification, pageable);

        if(userEntityPage.getContent() != null && !userEntityPage.getContent().isEmpty()) {
            userProfiles = new ArrayList<>();
            for(UserEntity userEntity : userEntityPage.getContent()) {
                userProfiles.add(mapper.map(userEntity, UserProfile.class));
            }
        }

        return userProfiles;
    }

    private List<SearchCriteria<UserEntity>> buildSearchCriteria(ProfileFilter profileFilter) {
        if(profileFilter == null) {
            return null;
        }
        List<SearchCriteria<UserEntity>> criteria = new ArrayList<SearchCriteria<UserEntity>>();

        if(!StringUtils.isEmpty(profileFilter.getEmail())) {
            criteria.add(new UserEmailSearchCriteria(profileFilter.getEmail()));
        }
        if(!StringUtils.isEmpty(profileFilter.getFirstName())) {
            criteria.add(new UserFirstNameSearchCriteria(profileFilter.getFirstName()));
        }
        if(!StringUtils.isEmpty(profileFilter.getLastName())) {
            criteria.add(new UserLastNameSearchCriteria(profileFilter.getLastName()));
        }
        return criteria;
    }
}
