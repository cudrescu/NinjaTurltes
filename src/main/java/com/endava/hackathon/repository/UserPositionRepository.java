package com.endava.hackathon.repository;

import com.endava.hackathon.model.UserPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPositionRepository extends JpaRepository<UserPositionEntity, Long>, JpaSpecificationExecutor<UserPositionEntity> {
}
