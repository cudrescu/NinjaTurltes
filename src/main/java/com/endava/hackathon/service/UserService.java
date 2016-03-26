package com.endava.hackathon.service;

import com.endava.hackathon.model.UserEntity;

public interface UserService {

    UserEntity findByUsername(String username);

}
