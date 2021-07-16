package com.example.demo.vip.service.impl;

import com.example.demo.vip.mapper.VipMapper;
import com.example.demo.vip.service.VipService;
import com.example.demo.pojo.Card;
import com.example.demo.pojo.MemberCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipServiceImpl implements VipService {
    @Autowired
    VipMapper vipMapper;


    //添加 VIP
    @Override
    public int add(Card card) {

        System.out.println(card);
        return vipMapper.add(card);
    }

    // update gym_member
    @Override
    public int updateVipStatus(MemberCard mc){

        System.out.println(mc);
        return vipMapper.updateVipStatus(mc);
    }

}
