package com.example.service.impl;

import com.example.mapper.CardVideoMapper;
import com.example.mapper.GymVideoMapper;
import com.example.pojo.*;
import com.example.service.VideoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service(version ="1.0.0")
public class VideoServiceImpl implements VideoService {
    @Autowired
    GymVideoMapper gymVideoMapper;
    @Autowired
    CardVideoMapper cardVideoMapper;

    @Override
    public List<Long> getVideoList(String card_id) {
        CardVideoExample example = new CardVideoExample();
        example.createCriteria().andCardIdEqualTo(card_id);
        List<Long> videoIdList = new ArrayList<>();
        for (CardVideo cv : cardVideoMapper.selectByExample(example)) {
            videoIdList.add(cv.getVideoId());
        }
        return videoIdList;
    }

    @Override
    public String getVideoUrl(long video_id) {
        return gymVideoMapper.selectByPrimaryKey(video_id).getVideourl();
    }

    @Override
    public double getVideoPrice(long video_id) {
        return gymVideoMapper.selectByPrimaryKey(video_id).getPrice();
    }

    @Override
    public GymVideo getVideo(long video_id) {
        return gymVideoMapper.selectByPrimaryKey(video_id);
    }

    @Override
    public int updateCardVideo(String card_id, long video_id) {
        CardVideo cv = new CardVideo();
        cv.setCardId(card_id);
        cv.setVideoId(video_id);
        try {
            cardVideoMapper.insert(cv);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public List<GymVideo> getAll() {
        GymVideoExample example = new GymVideoExample();
        example.createCriteria().getAllCriteria();
        return gymVideoMapper.selectByExample(example);
    }
}
