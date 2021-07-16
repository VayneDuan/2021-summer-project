package com.atguigu.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.boot.bean.*;
import javafx.util.Pair;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yiming Yang
 * @Edition: V1.0
 * @CreateDate: 2021/7/13 17:39
 * @Description:
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class HelloController {
    @RequestMapping("/course")
    public Course handle01(){
        List<Course> arrlist = new ArrayList<>();
        Course c1 = new Course("lifting", "16", "6:30 AM", "12:00 PM","images/feature-thumb1.png","Justin", "XXXXXXX");
        Course c2 = new Course("yoga", "10", "8:30 PM","12:00 PM","images/feature-thumb2.png", "Mike", "YYYYYYYYY");
        Course c3 = new Course("课程名","年份", "起始时间","结束时间", "images/feature-thumb3.png", "教练", "介绍");
        arrlist.add(c1);
        arrlist.add(c2);
        arrlist.add(c3);
        return c2;
    }

    @RequestMapping("/courses")
    public List<Course> cls(Model cname){
        List<Course> arrlist = new ArrayList<>();
        Course c1 = new Course("lifting", "16", "6:30 AM", "12:00 PM","images/feature-thumb1.png","Justin", "XXXXXXX");
        Course c2 = new Course("yoga", "10", "8:30 PM","12:00 PM","images/feature-thumb2.png", "Mike", "YYYYYYYYY");
        Course c3 = new Course("课程","年份", "起始时间","结束时间", "images/feature-thumb3.png", "教练", "介绍");
        arrlist.add(c1);
        arrlist.add(c2);
        arrlist.add(c3);
        return arrlist;
    }

    @RequestMapping("/trainer")
    public List<Person> handle02(){
        List<Person> arrList = new ArrayList<>();
        Person p1 = new Person("Justin Hessen", 20, "images/trainer1.png");
        Person p2 = new Person("Romia Rose", 30, "images/trainer2.png");
        Person p3 = new Person("Simron Wigs", 40, "images/trainer3.png");
        Person p4 = new Person("John Smile", 50, "images/trainer4.png");
        arrList.add(p1);
        arrList.add(p2);
        arrList.add(p3);
        arrList.add(p4);
        return arrList;
    }

    @RequestMapping("/trainers")
    public List<Pair<String, String>> handle03(){
        List<Pair<String, String>> arrList = new ArrayList<>();
        Pair p1 = new Pair("Justin Hessen","images/trainer1.png");
        Pair p2 = new Pair("Romia Rose","images/trainer2.png");
        Pair p3 = new Pair("Simron Wigs","images/trainer3.png");
        Pair p4 = new Pair("John Smile","images/trainer4.png");
        Pair p5 = new Pair("Mike Doe","images/trainer5.png");
        Pair p6 = new Pair("Jason Doenly","images/trainer6.png");
        Pair p7 = new Pair("Jane Doe","images/trainer7.png");
        arrList.add(p1);arrList.add(p2);arrList.add(p3);
        arrList.add(p4);arrList.add(p5);arrList.add(p6);
        arrList.add(p7);
        return arrList;
    }

    @RequestMapping("/forTrainerDetail")
    public forTrainerDetail handle04(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam.toJSONString());
        List<String> course = new ArrayList<>();
        course.add("七天速成");
        course.add("八天速成");
        course.add("九天速成");
        course.add("十天速成");
        forTrainerDetail trainer = new forTrainerDetail("张三","images/trainer1.png","97-02-04","XXXXXXXX",
                4.6,"略",course);
        return trainer;
    }

    @RequestMapping("/check")
    public Flag checkLogin(@RequestBody JSONObject jsonParam){
        Flag f = new Flag(true);
        System.out.println(jsonParam.toJSONString());
        return f;
    }

    @RequestMapping("/cart")
    public cart forUser(){
        cls c1 = new cls("七天学会跑步","julian1",1,500);
        cls c2 = new cls("七天学会游泳","julian2",2,400);
        cls c3 = new cls("七天学会跳水","julian3",1,300);
        cls c4 = new cls("七天学会举重","julian4",1,200);
        List<cls> arr = new ArrayList<>();
        arr.add(c1);
        arr.add(c2);
        arr.add(c3);
        arr.add(c4);
        cart ct = new cart("张三", arr);
        return ct;
    }

}
