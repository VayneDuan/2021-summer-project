package com.example.demo.mapper;

import com.example.demo.pojo.GymClass;
import com.example.demo.pojo.GymClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GymClassMapper {
    long countByExample(GymClassExample example);

    int deleteByExample(GymClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GymClass record);

    int insertSelective(GymClass record);

    List<GymClass> selectByExample(GymClassExample example);

    GymClass selectByPrimaryKey(Long id);

    List<GymClass> selectByCoachName(String coachName);

    int updateByExampleSelective(@Param("record") GymClass record, @Param("example") GymClassExample example);

    int updateByExample(@Param("record") GymClass record, @Param("example") GymClassExample example);

    int updateByPrimaryKeySelective(GymClass record);

    int updateByPrimaryKey(GymClass record);
}