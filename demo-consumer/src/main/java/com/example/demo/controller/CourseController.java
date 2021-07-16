package com.example.demo.controller;

import com.example.demo.pojo.GymClass;
import com.example.demo.service.CourseService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Reference
    private CourseService courseService;

    @RequestMapping("/test/{s}")
    public String findById(@PathVariable String s) {
        return courseService.test(s);
    }

    @RequestMapping("/{id}")
    public GymClass findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @RequestMapping("/all")
    public List<GymClass> findAll() {
        return courseService.findAll();
    }

    @RequestMapping("/findByCoachName/{coachName}")
    public List<GymClass> findByCoachName(@PathVariable String coachName){
        return courseService.findByCoachName(coachName);
    }
}
