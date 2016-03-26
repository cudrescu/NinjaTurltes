package com.endava.hackathon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="PROFILE")
public class ProfileEntity extends AbstractPersistable implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_POSITION_ID", nullable = false)
    private UserPositionEntity userPositionEntity;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "PROFILE_has_SKILL", catalog = "hackDB",
            joinColumns = { @JoinColumn(name = "SKILL_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "PROFILE_ID", nullable = false, updatable = false) })
    private List<SkillEntity> skillEntityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserPositionEntity getUserPositionEntity() {
        return userPositionEntity;
    }

    public void setUserPositionEntity(UserPositionEntity userPositionEntity) {
        this.userPositionEntity = userPositionEntity;
    }

    public List<SkillEntity> getSkillEntityList() {
        return skillEntityList;
    }

    public void setSkillEntityList(List<SkillEntity> skillEntityList) {
        this.skillEntityList = skillEntityList;
    }
}
