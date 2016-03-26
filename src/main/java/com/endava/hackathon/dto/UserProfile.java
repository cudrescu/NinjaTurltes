package com.endava.hackathon.dto;

import java.util.List;

public class UserProfile {

    private String email;
    private String firstName;
    private String lastName;
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

    public List<ProfileSkill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<ProfileSkill> skillList) {
        this.skillList = skillList;
    }
}
