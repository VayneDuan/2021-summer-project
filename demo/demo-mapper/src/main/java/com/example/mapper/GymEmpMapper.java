package com.example.mapper;

import com.example.pojo.GymEmp;
import com.example.pojo.GymEmpExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GymEmpMapper {
    long countByExample(GymEmpExample example);

    int deleteByExample(GymEmpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GymEmp record);

    int insertSelective(GymEmp record);

    List<GymEmp> selectByExample(GymEmpExample example);

    GymEmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GymEmp record, @Param("example") GymEmpExample example);

    int updateByExample(@Param("record") GymEmp record, @Param("example") GymEmpExample example);

    int updateByPrimaryKeySelective(GymEmp record);

    int updateByPrimaryKey(GymEmp record);
}