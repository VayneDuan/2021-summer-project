package com.example.mapper;

import com.example.pojo.GymCard;
import com.example.pojo.GymCardExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GymCardMapper {
    long countByExample(GymCardExample example);

    int deleteByExample(GymCardExample example);

    int deleteByPrimaryKey(String id);

    int insert(GymCard record);

    int insertSelective(GymCard record);

    List<GymCard> selectByExample(GymCardExample example);

    GymCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GymCard record, @Param("example") GymCardExample example);

    int updateByExample(@Param("record") GymCard record, @Param("example") GymCardExample example);

    int updateByPrimaryKeySelective(GymCard record);

    int updateByPrimaryKey(GymCard record);
}