package com.example.demo.login.service;

import com.example.demo.pojo.Member;

import java.util.List;

public interface LoginService {
    public List<Member> findAll();
    public Member findById(String id);
    //定义增删改查方法
    //添加数据
    public int add(Member member);
}
