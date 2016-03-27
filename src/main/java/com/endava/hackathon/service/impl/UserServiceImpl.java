package com.endava.hackathon.service.impl;

import com.endava.hackathon.criteria.*;
import com.endava.hackathon.dto.ProfileFilter;
import com.endava.hackathon.dto.ProfileSkill;
import com.endava.hackathon.dto.SearchResult;
import com.endava.hackathon.dto.UserProfile;
import com.endava.hackathon.exceptions.UserNotFoundException;
import com.endava.hackathon.model.ProfileHasSkillEntity;
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
        UserProfile userProfile =  mapper.map(userEntity, UserProfile.class);
        List<ProfileSkill> skillList = new ArrayList<>();
        for(ProfileHasSkillEntity profileHasSkillEntity : userEntity.getProfileEntity().getProfileHasSkillEntityList()) {
            skillList.add(mapper.map(profileHasSkillEntity, ProfileSkill.class));
        }
        userProfile.setSkillList(skillList);

        computeUserScore(userProfile);
        return userProfile;
    }

    @Override
    public SearchResult<UserProfile> searchUserProfiles(ProfileFilter profileFilter) {

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
                UserProfile userProfile = mapper.map(userEntity, UserProfile.class);
                List<ProfileSkill> skillList = new ArrayList<>();
                for(ProfileHasSkillEntity profileHasSkillEntity : userEntity.getProfileEntity().getProfileHasSkillEntityList()) {
                    skillList.add(mapper.map(profileHasSkillEntity, ProfileSkill.class));
                }
                userProfile.setSkillList(skillList);

                computeUserScore(userProfile);
                userProfiles.add(userProfile);
            }
        }

        return new SearchResult<>(userProfiles, userEntityPage.getTotalElements());
    }

    private void computeUserScore(UserProfile userProfile) {
        double totalScore = 0.0;
        int skillCount = 0;

        if (userProfile != null && userProfile.getSkillList() != null) {

            for (ProfileSkill profileSkill : userProfile.getSkillList()) {
                if (profileSkill != null && profileSkill.getScore() != null) {
                    totalScore += profileSkill.getScore();
                    skillCount++;
                }
            }

        }

        if (userProfile != null) {
            userProfile.setScore(totalScore / skillCount);
        }
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

        if(!StringUtils.isEmpty(profileFilter.getPosition())) {
            criteria.add(new UserPositionSearchCriteria(profileFilter.getPosition()));
        }

        return criteria;
    }
}
