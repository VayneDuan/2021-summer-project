package com.example.demo.login.mapper;

import com.example.demo.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {
    public List<Member> findAll();
    public Member findById(String id);
    //定义增删改查方法
    //添加数据
    public int add(Member member);
}
