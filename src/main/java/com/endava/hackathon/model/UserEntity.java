package com.endava.hackathon.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER")
public class UserEntity extends AbstractPersistable implements Serializable {

    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "profileEntity.firstName";
    public static final String LAST_NAME = "profileEntity.lastName";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @Column(name = "ENABLED")
    private boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private RoleEntity roleEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROFILE_ID", nullable = false)
    private ProfileEntity profileEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setProfileEntity(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }
}
