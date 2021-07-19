package com.example.service;

import com.example.pojo.GymCard;
import com.example.pojo.GymMember;

public interface VipService {

    int add(GymCard card);

    int updateVipStatus(GymMember member, String card_id);
}
