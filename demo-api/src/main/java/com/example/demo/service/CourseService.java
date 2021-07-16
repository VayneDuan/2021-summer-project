package com.example.demo.service;

import com.example.demo.pojo.GymClass;

import java.util.List;

public interface CourseService {
    public String test(String s);
    public GymClass findById(Long id);
    public List<GymClass> findAll();
    public List<GymClass> findByCoachName(String coachName);
}
