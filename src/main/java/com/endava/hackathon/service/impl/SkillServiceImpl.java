package com.endava.hackathon.service.impl;

import com.endava.hackathon.repository.SkillRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SkillServiceImpl {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private Mapper mapper;
}
