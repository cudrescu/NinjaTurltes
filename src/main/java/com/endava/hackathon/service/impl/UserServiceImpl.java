package com.endava.hackathon.service.impl;

import com.endava.hackathon.model.UserEntity;
import com.endava.hackathon.repository.UserRepository;
import com.endava.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
