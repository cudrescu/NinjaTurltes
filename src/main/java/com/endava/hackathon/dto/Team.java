package com.endava.hackathon.dto;

import org.springframework.security.core.userdetails.User;

import java.util.List;

public class Team {

    private String name;
    private String project;
    private List<UserProfile> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public List<UserProfile> getMembers() {
        return members;
    }

    public void setMembers(List<UserProfile> members) {
        this.members = members;
    }
}
