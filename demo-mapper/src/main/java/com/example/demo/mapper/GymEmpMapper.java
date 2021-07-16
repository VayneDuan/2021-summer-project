package com.example.demo.mapper;

import com.example.demo.pojo.GymEmp;
import com.example.demo.pojo.GymEmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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