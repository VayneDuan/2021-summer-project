package com.example.controller;

import com.example.pojo.GymNews;
import com.example.service.NewsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private NewsService newsService;

    @RequestMapping("/all")
    @ResponseBody
    public Map<String, Object> findAll() {
        Map<String,Object> data = new HashMap<>();
        data.put("all_news", newsService.findAll());
        return data;
    }
}
