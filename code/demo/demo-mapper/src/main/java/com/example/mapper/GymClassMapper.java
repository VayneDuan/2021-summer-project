package com.example.mapper;

import com.example.pojo.GymClass;
import com.example.pojo.GymClassExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GymClassMapper {
    long countByExample(GymClassExample example);

    int deleteByExample(GymClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GymClass record);

    int insertSelective(GymClass record);

    List<GymClass> selectByExample(GymClassExample example);

    GymClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GymClass record, @Param("example") GymClassExample example);

    int updateByExample(@Param("record") GymClass record, @Param("example") GymClassExample example);

    int updateByPrimaryKeySelective(GymClass record);

    int updateByPrimaryKey(GymClass record);
}