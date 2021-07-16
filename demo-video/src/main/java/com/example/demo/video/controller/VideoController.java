package com.example.demo.video.controller;

import com.example.demo.video.service.VideoService;
import com.example.demo.pojo.Card;
import com.example.demo.pojo.MemberCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class VideoController {
    @Autowired
    VideoService videoService;

    //TODO
    //* 实现思路:
        //* 1. 前端传入member_id, video_id
        //* 2. 通过member_id, 查DB拿到card_id (member_id可能不合法,报错 / 没开VIP的话, card_id可能不存在,返回提示开通VIP )
        //* 3. 通过card_id, 查DB拿到video_id_list, 遍历list, 看是否有和传入的video_id相同的id
        //*     3.1 如果存在, 通过这个video_id 查DB拿到url & name 等信息, 返回给前端, 是否返回整个页面还未确定, 需要和阳一鸣沟通
        //*     3.2 如果不存在, 返回: 权限不够, 请买课/买VIP
    @RequestMapping("/getVideo")
    public String getVideo(Model model,long video_id,String member_id="null"){
        boolean has_video = false;
        if(member_id!="null") {
            //验证用户是否存在
            String mem_id = videoService.getMemberID(member_id);
            if (mem_id == "-1") {
                model.addAttribute("user_error", "no such a user");
                System.out.println("user_error : no such a user");
                return "getVideo";
            }

            //判断是否为vip
            String card_id = videoService.getCardID(member_id);
            if (card_id == "-1") {
                model.addAttribute("vip_error", "you are not vip");
                System.out.println("vip_error : you are not vip");
                return "getVideo";
            }

            //查询VIP的video list
            if (videoService.getVideoList(card_id) == -1) {
                model.addAttribute("video_warnning", "no video provided");
                System.out.println("video_warnning : no video provided");
                return "getVideo";
            }
            List<long> video_list = videoService.getVideoList(card_id);

            //查询请求的视频是否可观看
            for (int i = 0; i < video_list.size(); i++) {
                if (video_id == video_list.get(i)) {
                    has_video = true;
                    break;
                }
            }
            if (!has_video) {
                model.addAttribute("video_forbidden", "yes");
                System.out.println("video_forbidden : yes");
                return "getVideo";
            }
        }
        //获取video信息
        try {
            Video select_video = videoService.getVideo(video_id);
            if(select_video.price==0  || has_video){//视频免费(登录与否都可看) or 用户有VIP
                model.addAttribute("video_name", select_video.gym_video_name);
                model.addAttribute("video_url", select_video.videoUrl);
                return "Video";  //暂时未实现
            }
            else if(select_video.price!=0 and !has_video){ //非vip看付费视频
                model.addAttribute("video_forbidden", "yes");
                System.out.println("video_forbidden : yes");
                return "getVideo";
            }

        }
        catch (Exception e){
            model.addAttribute("video_warnning", "no video provided");
            System.out.println("video_warnning : no video provided");
        }
    }


}
