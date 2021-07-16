package com.example.demo.service.impl;

import com.example.demo.mapper.GymClassMapper;
import com.example.demo.pojo.GymClass;
import com.example.demo.service.CourseService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private GymClassMapper courseMapper;

    @Override
    public String test(String s) {
        return s;
    }

    @Override
    public GymClass findById(Long id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GymClass> findAll() {
        return null;
    }

    @Override
    public List<GymClass> findByCoachName(String coachName) {
        return courseMapper.selectByCoachName(coachName);
    }

}
