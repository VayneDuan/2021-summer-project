package com.example.demo.video.mapper;
import java.util.ArrayList;
import com.example.demo.pojo.Card;
import com.example.demo.pojo.Video;
import com.example.demo.pojo.MemberCard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Mapper
@Repository
public interface VideoMapper {

    public String getMemberID(String member_id);
    public String getCardID(String member_id);
    public List<long> getVideoList(String card_id);
    public long getVideoID(long video_id);
    public String getVideoUrl(long video_id);
    public double getVideoPrice(long video_id);
    public Video getVideo(long video_id);
}
