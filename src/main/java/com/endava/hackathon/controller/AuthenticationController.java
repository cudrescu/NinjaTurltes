package com.endava.hackathon.controller;

import com.endava.hackathon.dto.UserCredentials;
import com.endava.hackathon.service.security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CustomUserDetails login(@RequestBody UserCredentials userCredentials) {
        return null;
    }

}
