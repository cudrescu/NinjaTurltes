package com.endava.hackathon.repository;

import com.endava.hackathon.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeamRepository extends JpaRepository<TeamEntity, Long>, JpaSpecificationExecutor<TeamEntity> {
}
