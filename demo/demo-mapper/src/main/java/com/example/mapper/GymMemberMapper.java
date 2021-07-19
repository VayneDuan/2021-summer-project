package com.example.mapper;

import com.example.pojo.GymMember;
import com.example.pojo.GymMemberExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GymMemberMapper {
    long countByExample(GymMemberExample example);

    int deleteByExample(GymMemberExample example);

    int deleteByPrimaryKey(String id);

    int insert(GymMember record);

    int insertSelective(GymMember record);

    List<GymMember> selectByExample(GymMemberExample example);

    GymMember selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GymMember record, @Param("example") GymMemberExample example);

    int updateByExample(@Param("record") GymMember record, @Param("example") GymMemberExample example);

    int updateByPrimaryKeySelective(GymMember record);

    int updateByPrimaryKey(GymMember record);
}