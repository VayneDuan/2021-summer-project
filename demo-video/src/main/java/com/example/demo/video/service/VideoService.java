package com.example.demo.video.service;

import com.example.demo.pojo.Card;
import com.example.demo.pojo.MemberCard;

import java.util.List;

public interface VideoService {

    //! 以下都是旧的, 大纲请参看 videoMapper.xml
    //ADD VIP INFO to gym_card
    //public int add(Card card);
    // update gym_member
    //public int updateVipStatus(MemberCard mc);
    public String getMemberID(String member_id);
    public String getCardID(String member_id);
    public List<long> getVideoList(String card_id);
    public String getVideoUrl(long video_id);
    public double getVideoPrice(long video_id);
    public Video getVideo(long video_id);
}
