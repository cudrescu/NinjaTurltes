package com.endava.hackathon.service.impl;

import com.endava.hackathon.dto.UserCredentials;
import com.endava.hackathon.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    @Qualifier("myUserDetailsServiceImpl")
    private UserDetailsService myUserDetailsServiceImpl;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @Override
    public UserDetails login(UserCredentials userCredentials) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userCredentials.getEmail(), userCredentials.getPassword());
        Authentication authentication = authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return myUserDetailsServiceImpl.loadUserByUsername(userCredentials.getEmail());
    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession context = request.getSession(false);
        if(context != null) {
            context.invalidate();
        }
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(null);

        SecurityContextHolder.clearContext();
    }
}
