package com.endava.hackathon.service;

import com.endava.hackathon.dto.UserCredentials;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    UserDetails login(UserCredentials userCredentialsDTO);

    void logout(HttpServletRequest request);

}