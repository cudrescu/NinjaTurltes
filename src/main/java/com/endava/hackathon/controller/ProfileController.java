package com.endava.hackathon.controller;

import com.endava.hackathon.dto.ProfileFilter;
import com.endava.hackathon.dto.SearchResult;
import com.endava.hackathon.dto.UserProfile;
import com.endava.hackathon.exceptions.UserNotFoundException;
import com.endava.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SearchResult<UserProfile> search(@RequestBody ProfileFilter profileFilter) {
        return userService.searchUserProfiles(profileFilter);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserProfile getUserProfile(@RequestParam(value = "email") String email) throws UserNotFoundException {
        return userService.getUserProfile(email);
    }

}
