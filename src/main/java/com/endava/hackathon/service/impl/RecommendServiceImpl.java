package com.endava.hackathon.service.impl;

import com.endava.hackathon.dto.*;
import com.endava.hackathon.service.RecommendService;
import com.endava.hackathon.service.UserService;
import com.endava.hackathon.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class RecommendServiceImpl implements RecommendService {
    private final static Integer PAGE_SIZE = 100;
    private final static Integer TOTAL_RECOMMENDED_ITEMS = 5;

    @Autowired
    private UserService userService;

    private ProfileFilter initProfileFilter(int pageSize, int pageNumber, String position) {
        ProfileFilter profileFilter = new ProfileFilter();
        profileFilter.setPageSize(pageSize);
        profileFilter.setPageNumber(pageNumber);
        profileFilter.setPosition(position);
        return profileFilter;
    }

    private double calculateDistanceBetweenSkills(ProfileSkill ratedSkill, ProfileSkill userSkill) {
        return Math.abs(ratedSkill.getScore() - userSkill.getScore());
    }

    private double calculateDistance(List<ProfileSkill> ratedSkills, List<ProfileSkill> userSkills) {
        double totalDistance = 0.0;
        double currentDistance;
        for (ProfileSkill ratedSkill : ratedSkills) {
            currentDistance = ratedSkill.getScore();

            for (ProfileSkill userSkill : userSkills) {
                if (ratedSkill.getName().equals(userSkill.getName())) {
                    currentDistance = calculateDistanceBetweenSkills(ratedSkill, userSkill);
                    break;
                }
            }

            totalDistance += currentDistance;
        }
        return totalDistance;
    }

    private void insertInLimitedSizePriorityQueue(Queue<Pair<Double, UserProfile>> recommendedUserPairs,
                                                  int maxSize, Double distance, UserProfile userProfile) {
        recommendedUserPairs.add(new Pair<>(distance, userProfile));
        if (recommendedUserPairs.size() > maxSize) {
            recommendedUserPairs.poll();
        }
    }

    private List<UserProfile> extractUserProfiles(Queue<Pair<Double, UserProfile>> recommendedUserPairs) {
        if (recommendedUserPairs == null){
            return null;
        }

        List<UserProfile> userProfiles = new ArrayList<>(recommendedUserPairs.size());

        Pair<Double, UserProfile> currentPair = recommendedUserPairs.poll();
        while (currentPair != null) {
            userProfiles.add(currentPair.getRight());
            currentPair = recommendedUserPairs.poll();
        }

        Collections.reverse(userProfiles);
        return userProfiles;
    }

    @Override
    public List<UserProfile> recommend(RecommendFilter recommendFilter) {
        int pageNumber = 1;
        Long totalItems;
        List<UserProfile> currentUserProfiles;
        {
            SearchResult<UserProfile> usersSearchResult = userService.searchUserProfiles(initProfileFilter(PAGE_SIZE, pageNumber, recommendFilter.getPosition()));
            currentUserProfiles = usersSearchResult.getItems();
            totalItems = usersSearchResult.getTotalItems();
        }

        Queue<Pair<Double, UserProfile>> recommendedUserPairs = new PriorityQueue<>(TOTAL_RECOMMENDED_ITEMS + 1);

        while ((pageNumber - 1) * PAGE_SIZE < totalItems) {

            pageNumber++;

            for (UserProfile currentUserProfile : currentUserProfiles) {
                Double distance = calculateDistance(recommendFilter.getSkills(), currentUserProfile.getSkillList());
                insertInLimitedSizePriorityQueue(recommendedUserPairs, TOTAL_RECOMMENDED_ITEMS, distance, currentUserProfile);
            }

            currentUserProfiles = userService.searchUserProfiles(initProfileFilter(PAGE_SIZE, pageNumber, recommendFilter.getPosition())).getItems();
        }

        return extractUserProfiles(recommendedUserPairs);
    }
}
