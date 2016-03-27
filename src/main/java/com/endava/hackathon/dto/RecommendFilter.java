package com.endava.hackathon.dto;

import java.util.List;

public class RecommendFilter {

    private List<ProfileSkill> skills;
    private String position;

    public List<ProfileSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<ProfileSkill> skills) {
        this.skills = skills;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
