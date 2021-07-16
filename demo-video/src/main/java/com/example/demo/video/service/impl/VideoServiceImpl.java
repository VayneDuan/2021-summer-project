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

    @Override
    public String getMemberID(String member_id){
        return  videoMapper.getMemberID(member_id);
    }

    @Override
    public String getCardID(String member_id){
        return videoMapper.getCardId(member_id);
    }

    @Override
    public List<long> getVideoList(String card_id){
        return videoMapper.getVideoList(card_id);
    }

    @Override
    public String getVideoUrl(long video_id){
        return videoMapper.getVideoUrl(video_id);
    }

    @Override
    public double getVideoPrice(long video_id){
        return videoMapper.getVideoPrice(video_id);
    }

    @Override
    public Video getVideo(long video_id){
        return videoMapper.getVideo(video_id);
    }
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
