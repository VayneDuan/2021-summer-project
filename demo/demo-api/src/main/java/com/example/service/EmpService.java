package com.example.service;

import com.example.pojo.GymEmp;

import java.util.List;

public interface EmpService {
    List<GymEmp> findByMajor(String major);

    List<GymEmp> findByName(String name);

    List<GymEmp> findAll();

    GymEmp findById(Long id);
}
