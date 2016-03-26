package com.endava.hackathon.util;

import com.endava.hackathon.model.NamedEntity;
import com.endava.hackathon.model.SkillCategoryEntity;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class MappingUtils {
    public static <S, D> List<D> mapList(Mapper mapper, List<S> originalList, Class<D> hint) {
        if (originalList == null) {
            return null;
        }

        List<D> newList = new ArrayList<>(originalList.size());
        for (S elem : originalList) {
            newList.add(mapper.map(elem, hint));
        }
        return newList;
    }

    public static List<String> getEntityNames(List<? extends NamedEntity> originalList) {
        if (originalList == null) {
            return null;
        }

        List<String> skillCategoriesNames = new ArrayList<>(originalList.size());
        for (NamedEntity elem : originalList) {
            skillCategoriesNames.add(elem.getName());
        }
        return skillCategoriesNames;
    }
}
