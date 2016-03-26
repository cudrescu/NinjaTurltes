package com.endava.hackathon.service.impl;

import com.endava.hackathon.repository.UserPositionRepository;
import com.endava.hackathon.service.UserPositionService;
import com.endava.hackathon.util.MappingUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserPositionServiceImpl implements UserPositionService {

    @Autowired
    private UserPositionRepository userPositionRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<String> getAll() {
        return MappingUtils.getEntityNames(userPositionRepository.findAll());
    }
}
