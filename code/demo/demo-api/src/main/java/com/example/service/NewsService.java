package com.example.service;

import com.example.pojo.GymNews;

import java.util.List;

public interface NewsService {
    List<GymNews> findAll();
}
