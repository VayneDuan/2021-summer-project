package com.example.mapper;

import com.example.pojo.GymLockers;
import com.example.pojo.GymLockersExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GymLockersMapper {
    long countByExample(GymLockersExample example);

    int deleteByExample(GymLockersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GymLockers record);

    int insertSelective(GymLockers record);

    List<GymLockers> selectByExample(GymLockersExample example);

    GymLockers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GymLockers record, @Param("example") GymLockersExample example);

    int updateByExample(@Param("record") GymLockers record, @Param("example") GymLockersExample example);

    int updateByPrimaryKeySelective(GymLockers record);

    int updateByPrimaryKey(GymLockers record);
}