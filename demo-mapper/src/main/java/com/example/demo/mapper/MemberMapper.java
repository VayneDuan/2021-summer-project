package com.example.demo.mapper;

import com.example.demo.pojo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> findAll();
    Member findById(String id);
}