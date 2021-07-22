package com.example.mapper;

import com.example.pojo.CardVideo;
import com.example.pojo.CardVideoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CardVideoMapper {
    long countByExample(CardVideoExample example);

    int deleteByExample(CardVideoExample example);

    int insert(CardVideo record);

    int insertSelective(CardVideo record);

    List<CardVideo> selectByExample(CardVideoExample example);

    int updateByExampleSelective(@Param("record") CardVideo record, @Param("example") CardVideoExample example);

    int updateByExample(@Param("record") CardVideo record, @Param("example") CardVideoExample example);
}