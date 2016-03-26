package com.endava.hackathon.service.impl;

import com.endava.hackathon.dto.Skill;
import com.endava.hackathon.model.SkillEntity;
import com.endava.hackathon.repository.SkillRepository;
import com.endava.hackathon.service.SkillService;
import com.endava.hackathon.util.DozerUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<Skill> getAll() {
        return DozerUtils.mapList(mapper, skillRepository.findAll(), Skill.class);
    }
}
