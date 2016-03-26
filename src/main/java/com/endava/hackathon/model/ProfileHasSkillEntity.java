package com.endava.hackathon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="PROFILE_has_SKILL")
public class ProfileHasSkillEntity {

    @Embeddable
    class ProfileHasSkillEntityPK {
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "PROFILE_ID", nullable = false)
        private ProfileEntity profileEntity;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "SKILL_ID", nullable = false)
        private SkillEntity skillEntity;

        public ProfileHasSkillEntityPK(ProfileEntity profileEntity, SkillEntity skillEntity) {
            this.profileEntity = profileEntity;
            this.skillEntity = skillEntity;
        }

        public ProfileEntity getProfileEntity() {
            return profileEntity;
        }

        public void setProfileEntity(ProfileEntity profileEntity) {
            this.profileEntity = profileEntity;
        }

        public SkillEntity getSkillEntity() {
            return skillEntity;
        }

        public void setSkillEntity(SkillEntity skillEntity) {
            this.skillEntity = skillEntity;
        }
    }

    @EmbeddedId
    private ProfileHasSkillEntityPK id;

    @Column(name="SCORE")
    private Double score;

    public ProfileHasSkillEntityPK getId() {
        return id;
    }

    public void setId(ProfileHasSkillEntityPK id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
