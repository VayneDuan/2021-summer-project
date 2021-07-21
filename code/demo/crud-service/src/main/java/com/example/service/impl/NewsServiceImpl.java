package com.example.service.impl;

import com.example.mapper.GymNewsMapper;
import com.example.pojo.GymNews;
import com.example.pojo.GymNewsExample;
import com.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version ="1.0.0")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private GymNewsMapper gymNewsMapper;

    @Override
    public List<GymNews> findAll() {
        GymNewsExample example = new GymNewsExample();
        example.createCriteria().getAllCriteria();
        example.setOrderByClause("news_date DESC");
        return gymNewsMapper.selectByExample(example);
    }
}
