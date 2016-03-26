package com.endava.hackathon.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="SKILL")
public class SkillEntity extends AbstractPersistable implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NAME")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SKILL_CATEGORY_ID", nullable = false)
    private SkillCategoryEntity skillCategoryEntity;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "skillEntityList")
    private ProfileEntity profileEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillCategoryEntity getSkillCategoryEntity() {
        return skillCategoryEntity;
    }

    public void setSkillCategoryEntity(SkillCategoryEntity skillCategoryEntity) {
        this.skillCategoryEntity = skillCategoryEntity;
    }

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setProfileEntity(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }
}
