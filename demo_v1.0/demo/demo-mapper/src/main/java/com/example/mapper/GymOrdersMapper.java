package com.example.mapper;

import com.example.pojo.GymOrders;
import com.example.pojo.GymOrdersExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GymOrdersMapper {
    long countByExample(GymOrdersExample example);

    int deleteByExample(GymOrdersExample example);

    int deleteByPrimaryKey(String id);

    int insert(GymOrders record);

    int insertSelective(GymOrders record);

    List<GymOrders> selectByExample(GymOrdersExample example);

    GymOrders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GymOrders record, @Param("example") GymOrdersExample example);

    int updateByExample(@Param("record") GymOrders record, @Param("example") GymOrdersExample example);

    int updateByPrimaryKeySelective(GymOrders record);

    int updateByPrimaryKey(GymOrders record);
}