package com.example.mapper;

import com.example.pojo.GymVideo;
import com.example.pojo.GymVideoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GymVideoMapper {
    long countByExample(GymVideoExample example);

    int deleteByExample(GymVideoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GymVideo record);

    int insertSelective(GymVideo record);

    List<GymVideo> selectByExample(GymVideoExample example);

    GymVideo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GymVideo record, @Param("example") GymVideoExample example);

    int updateByExample(@Param("record") GymVideo record, @Param("example") GymVideoExample example);

    int updateByPrimaryKeySelective(GymVideo record);

    int updateByPrimaryKey(GymVideo record);
}