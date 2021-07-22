package com.example.mapper;

import com.example.pojo.CardClass;
import com.example.pojo.CardClassExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CardClassMapper {
    long countByExample(CardClassExample example);

    int deleteByExample(CardClassExample example);

    int insert(CardClass record);

    int insertSelective(CardClass record);

    List<CardClass> selectByExample(CardClassExample example);

    int updateByExampleSelective(@Param("record") CardClass record, @Param("example") CardClassExample example);

    int updateByExample(@Param("record") CardClass record, @Param("example") CardClassExample example);
}