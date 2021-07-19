package com.example.service.impl;

import com.example.mapper.GymCardMapper;
import com.example.mapper.GymMemberMapper;
import com.example.pojo.GymCard;
import com.example.pojo.GymMember;
import com.example.service.VipService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class VipServiceImpl implements VipService {
    @Autowired
    private GymCardMapper gymCardMapper;
    @Autowired
    private GymMemberMapper gymMemberMapper;

    @Override
    public int add(GymCard card) {
        try {
            gymCardMapper.insert(card);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int updateVipStatus(GymMember member, String card_id) {
        member.setCardId(card_id);
        try {
            gymMemberMapper.updateByPrimaryKey(member);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
}
