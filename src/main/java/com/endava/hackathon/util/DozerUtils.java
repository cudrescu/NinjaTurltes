package com.endava.hackathon.util;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Project hack
 * Created by vdinu on 3/26/2016.
 */
public class DozerUtils {
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
}
