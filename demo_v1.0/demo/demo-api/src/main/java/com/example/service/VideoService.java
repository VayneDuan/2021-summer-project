package com.example.service;

import com.example.pojo.GymVideo;

import java.util.List;

public interface VideoService {
    List<Long> getVideoList(String card_id);
    String getVideoUrl(long video_id);
    double getVideoPrice(long video_id);
    GymVideo getVideo(long video_id);
    int updateCardVideo(String card_id, long video_id);
    List<GymVideo> getAll();
}
