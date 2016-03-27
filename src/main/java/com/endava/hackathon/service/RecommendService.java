package com.endava.hackathon.service;

import com.endava.hackathon.dto.RecommendFilter;
import com.endava.hackathon.dto.UserProfile;

import java.util.List;

public interface RecommendService {
    List<UserProfile> recommend(RecommendFilter recommendFilter);
}
