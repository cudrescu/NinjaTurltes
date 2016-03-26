package com.endava.hackathon.repository;

import com.endava.hackathon.model.SkillCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillCategoryRepository extends JpaRepository<SkillCategoryEntity, Long>, JpaSpecificationExecutor<SkillCategoryEntity> {
}
