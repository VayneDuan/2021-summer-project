package com.example.mapper;

import com.example.pojo.GymNews;
import com.example.pojo.GymNewsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GymNewsMapper {
    long countByExample(GymNewsExample example);

    int deleteByExample(GymNewsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GymNews record);

    int insertSelective(GymNews record);

    List<GymNews> selectByExample(GymNewsExample example);

    GymNews selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GymNews record, @Param("example") GymNewsExample example);

    int updateByExample(@Param("record") GymNews record, @Param("example") GymNewsExample example);

    int updateByPrimaryKeySelective(GymNews record);

    int updateByPrimaryKey(GymNews record);
}