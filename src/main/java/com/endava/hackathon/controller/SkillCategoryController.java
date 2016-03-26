package com.endava.hackathon.controller;

import com.endava.hackathon.dto.SkillCategory;
import com.endava.hackathon.service.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequestMapping(value = "/api/skillcategory")
public class SkillCategoryController {

    @Autowired
    private SkillCategoryService skillCategoryService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<SkillCategory> search() {
        return skillCategoryService.getAll();
    }
}
