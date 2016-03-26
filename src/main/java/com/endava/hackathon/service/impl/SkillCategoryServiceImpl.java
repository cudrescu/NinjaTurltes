package com.endava.hackathon.service.impl;

import com.endava.hackathon.dto.SkillCategory;
import com.endava.hackathon.repository.SkillCategoryRepository;
import com.endava.hackathon.service.SkillCategoryService;
import com.endava.hackathon.util.DozerUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SkillCategoryServiceImpl implements SkillCategoryService {

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<SkillCategory> getAll() {
        return DozerUtils.mapList(mapper, skillCategoryRepository.findAll(), SkillCategory.class);
    }
}
