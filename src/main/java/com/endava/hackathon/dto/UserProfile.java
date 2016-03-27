package com.endava.hackathon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserProfile {

    private String email;
    private String firstName;
    private String lastName;
    private String position;
    private Double score;
    private List<ProfileSkill> skillList;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<ProfileSkill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<ProfileSkill> skillList) {
        this.skillList = skillList;
    }
}
