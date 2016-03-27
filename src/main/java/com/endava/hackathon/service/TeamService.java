package com.endava.hackathon.service;

import com.endava.hackathon.dto.Team;

import java.util.List;

public interface TeamService {

    List<String> getTeamNames();

    void saveTeam(Team team);
}
