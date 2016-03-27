package com.endava.hackathon.controller;

import com.endava.hackathon.exceptions.UserNotFoundException;
import com.endava.hackathon.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    private Map<String, String> savedTeams = new HashMap<>();

    @RequestMapping(value = "/all/names", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<String> search() {
        return teamService.getTeamNames();
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getSavedTeam(@RequestParam(value = "email") String email) {
        return savedTeams.get(email);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getUserProfile(@RequestParam(value = "email") String email, @RequestBody String body) {
        return savedTeams.put(email, body);
    }
}
