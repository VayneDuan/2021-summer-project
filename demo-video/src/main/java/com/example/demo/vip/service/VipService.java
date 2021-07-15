package com.example.demo.vip.service;

import com.example.demo.pojo.Card;
import com.example.demo.pojo.MemberCard;

import java.util.List;

public interface VipService {
    //ADD VIP INFO to gym_card
    public int add(Card card);
    // update gym_member
    public int updateVipStatus(MemberCard mc);
}
