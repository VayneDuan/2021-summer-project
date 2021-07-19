package com.example.mapper;

import com.example.pojo.GymEquipment;
import com.example.pojo.GymEquipmentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GymEquipmentMapper {
    long countByExample(GymEquipmentExample example);

    int deleteByExample(GymEquipmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GymEquipment record);

    int insertSelective(GymEquipment record);

    List<GymEquipment> selectByExample(GymEquipmentExample example);

    GymEquipment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GymEquipment record, @Param("example") GymEquipmentExample example);

    int updateByExample(@Param("record") GymEquipment record, @Param("example") GymEquipmentExample example);

    int updateByPrimaryKeySelective(GymEquipment record);

    int updateByPrimaryKey(GymEquipment record);
}