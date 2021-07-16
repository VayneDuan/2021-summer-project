package com.example.demo.mapper.controller;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberMapper memberMapper;

    @RequestMapping("/{id}")
    public Member findById(@PathVariable String id) {
        return memberMapper.findById(id);
    }

    @RequestMapping("/all")
    public List<Member> findAll() {
        return memberMapper.findAll();
    }
}
