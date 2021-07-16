package com.example.demo.video.service.impl;

import com.example.demo.video.mapper.VideoMapper;
import com.example.demo.video.service.VideoService;
import com.example.demo.pojo.Card;
import com.example.demo.pojo.MemberCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;


    // //添加 VIP
    // @Override
    // public int add(Card card) {

    //     System.out.println(card);
    //     return vipMapper.add(card);
    // }

    // // update gym_member
    // @Override
    // public int updateVipStatus(MemberCard mc){

    //     System.out.println(mc);
    //     return vipMapper.updateVipStatus(mc);
    // }

}
