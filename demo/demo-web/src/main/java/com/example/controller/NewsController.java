package com.example.controller;

import com.example.pojo.GymNews;
import com.example.service.NewsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Reference
    private NewsService newsService;

    @RequestMapping("/all")
    @ResponseBody
    public List<GymNews> findAll() {
        return newsService.findAll();
    }
}
