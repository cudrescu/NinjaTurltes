package com.endava.hackathon.service.impl;

import com.endava.hackathon.dto.Team;
import com.endava.hackathon.repository.TeamRepository;
import com.endava.hackathon.service.TeamService;
import com.endava.hackathon.util.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    private Map<String, Team> savedTeams = new HashMap<>();

    @Override
    public List<String> getTeamNames() {
        return MappingUtils.getEntityNames(teamRepository.findAll());
    }

    @Override
    public void saveTeam(Team team) {
        this.savedTeams.put(team.getName(), team);
    }
}
