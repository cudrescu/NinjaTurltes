package com.endava.hackathon.controller;

import com.endava.hackathon.dto.RecommendFilter;
import com.endava.hackathon.dto.UserProfile;
import com.endava.hackathon.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<UserProfile> search(@RequestBody RecommendFilter recommendFilter) {
        return recommendService.recommend(recommendFilter);
    }
}
