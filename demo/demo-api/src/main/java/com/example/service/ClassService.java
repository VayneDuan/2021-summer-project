package com.example.service;

import com.example.pojo.GymClass;
import com.example.pojo.GymMember;

import java.util.List;

public interface ClassService {
    List<GymClass> findByName(String className);

    GymClass findById(long id);

    int updateCardClass(String card_id, long class_id);

    List<GymClass> findAll();
}
