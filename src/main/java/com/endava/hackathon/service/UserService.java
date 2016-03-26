package com.endava.hackathon.service;

import com.endava.hackathon.dto.ProfileFilter;
import com.endava.hackathon.dto.SearchResult;
import com.endava.hackathon.dto.UserProfile;
import com.endava.hackathon.exceptions.UserNotFoundException;
import com.endava.hackathon.model.UserEntity;

public interface UserService {

    UserEntity findByEmail(String email);

    UserProfile getUserProfile(String email) throws UserNotFoundException;

    SearchResult<UserProfile> searchUserProfiles(ProfileFilter profileFilter);

}
