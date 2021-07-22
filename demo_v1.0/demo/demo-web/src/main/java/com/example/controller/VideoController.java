package com.example.controller;

import com.example.pojo.GymMember;
import com.example.pojo.GymVideo;
import com.example.service.AlipayService;
import com.example.service.MemberService;
import com.example.service.VideoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/videos")
public class VideoController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Reference(version = "1.0.0", url = "dubbo://localhost:20891?version=1.0.0")
    private VideoService videoService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private MemberService memberService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20894?version=1.0.0")
    private AlipayService alipayService;

    //TODO
    //* 实现思路:
    //* 1. 前端传入member_id, video_id
    //* 2. 通过member_id, 查DB拿到card_id (member_id可能不合法,报错 / 没开VIP的话, card_id可能不存在,返回提示开通VIP )
    //* 3. 通过card_id, 查DB拿到video_id_list, 遍历list, 看是否有和传入的video_id相同的id
    //*     3.1 如果存在, 通过这个video_id 查DB拿到url & name 等信息, 返回给前端, 是否返回整个页面还未确定, 需要和阳一鸣沟通
    //*     3.2 如果不存在, 返回: 权限不够, 请买课/买VIP

    @RequestMapping("getAll")
    public Map<String, Object> get() {
        Map<String, Object> msg = new HashMap<>();
        List<GymVideo> videos = videoService.getAll();
        List<Map<String, String>> videoList = new ArrayList<>();
        for (int i=0;i<5;i++) {
            Map<String, String> info = new HashMap<>();
            info.put("name", videos.get(i).getGymVideoName().split("\\.")[1]);
            info.put("url", "http://192.168.3.1:18888/" + videos.get(i).getVideourl());
            videoList.add(info);
        }
        msg.put("data", videoList);
        return msg;
    }

    @RequestMapping("/get")
    public Map<String, Object> getVideo(@RequestBody Map<String, Object> req) {
        String phone = (String) req.get("phone");
        long video_id = (long) req.get("video_id");
//        long video_id = Long.parseLong(request.getParameter("video_id"));
//        String member_id = request.getParameter("member_id");
        Map<String, Object> msg = new HashMap<>();
        boolean has_video = false;
        if (phone != null) {
            //验证用户是否存在
            GymMember member = memberService.findByPhone(phone);
            if (member == null) {
                msg.put("video", "error");
                System.out.println("user_error : no such a user");
                return msg;
            }

            //判断是否为vip
            String card_id = member.getCardId();
            if (card_id == null) {
                msg.put("video", "error");
                System.out.println("vip_error : you are not vip");
                return msg;
            }

            //查询VIP的video list
            if (videoService.getVideoList(card_id).size() == 0) {
                msg.put("video", "error");
                System.out.println("video_warning : no video provided");
                return msg;
            }
            List<Long> video_list = videoService.getVideoList(card_id);

            // 查询请求的视频是否可观看
            for (Long v_id : video_list) {
                if (video_id == v_id) {
                    has_video = true;
                    break;
                }
            }
            if (!has_video) {
                msg.put("video", "error");
                System.out.println("video_forbidden : yes");
                return msg;
            }
        }
        //获取video信息
        try {
            GymVideo select_video = videoService.getVideo(video_id);
            if (select_video.getPrice() == 0 || has_video) { // 视频免费(登录与否都可看) or 用户有VIP
                msg.put("video", "success");
                msg.put("data", select_video.getVideourl());
            } else if (select_video.getPrice() != 0 && !has_video) { //非vip看付费视频
                msg.put("video", "error");
                System.out.println("video_forbidden : yes");
                return msg;
            }
        } catch (Exception e) {
            msg.put("video", "error");
            System.out.println("video_warning : no video provided");
            return msg;
        }
        return msg;
    }

//    @RequestMapping("buy")
//    public Map<String,Object> buyVideo(@RequestBody GymVideo video, HttpServletRequest request) {
//        String phone = request.getParameter("phone");
//        GymMember member = memberService.findByPhone(phone);
//        Date createTime = new Date();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(createTime);
//        //! 写db
//        try {
//            videoService.updateCardVideo(member.getCardId(), video.getId());
//        } catch (Exception e) {
//            Map<String,Object> add_error = new HashMap<>();
//            add_error.put("video", "error");
//            System.out.println("video_exception : 发生未知错误，添加数据库失败");
//            return add_error;
//        }
//        Map<String,Object> add_success = new HashMap<>();
//        add_success.put("video", "success");
//        add_success.put("address", "home");
//        return add_success;
//    }

}
