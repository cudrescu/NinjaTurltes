package com.endava.hackathon.controller;

import com.endava.hackathon.dto.UserCredentials;
import com.endava.hackathon.service.AuthenticationService;
import com.endava.hackathon.service.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserDetails login(@RequestBody UserCredentials userCredentials) {
        return authenticationService.login(userCredentials);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void logout(HttpServletRequest request) {
        authenticationService.logout(request);
    }

}
