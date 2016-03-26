package com.endava.hackathon.service.impl;

import com.endava.hackathon.repository.TeamRepository;
import com.endava.hackathon.service.TeamService;
import com.endava.hackathon.util.MappingUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<String> getTeamNames() {
        return MappingUtils.getEntityNames(teamRepository.findAll());
    }
}
