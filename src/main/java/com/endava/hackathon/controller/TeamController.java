package com.endava.hackathon.controller;

import com.endava.hackathon.dto.Team;
import com.endava.hackathon.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/all/names", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<String> search() {
        return teamService.getTeamNames();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void saveTeam(@RequestBody Team team) {
        teamService.saveTeam(team);
    }
}
