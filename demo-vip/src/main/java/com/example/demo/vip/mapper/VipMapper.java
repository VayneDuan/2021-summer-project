package com.example.demo.vip.mapper;

import com.example.demo.pojo.Card;
import com.example.demo.pojo.MemberCard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VipMapper {

    //添加 VIP
    public int add(Card card);
    //update gym_member
    public int updateVipStatus(MemberCard mc);
}
