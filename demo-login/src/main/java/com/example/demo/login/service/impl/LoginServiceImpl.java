package com.example.demo.login.service.impl;

import com.example.demo.login.mapper.LoginMapper;
import com.example.demo.login.service.LoginService;
import com.example.demo.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public List<Member> findAll() {
        return loginMapper.findAll();
    }

    @Override
    public Member findById(String id) {
        return loginMapper.findById(id);
    }

    @Override
    public int add(Member member) {
        member.setId(8888888);
        member.setImgUrl("#");
        member.setCard_id(-1);
        member.setCoach_id(-1);
        System.out.println(member);
        return loginMapper.add(member);
    }
}
