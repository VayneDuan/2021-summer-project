package com.example.controller;

import com.example.pojo.GymClass;
import com.example.pojo.GymMember;
import com.example.pojo.GymVideo;
import com.example.service.MemberService;
import com.example.service.VideoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/videos")
public class VideoController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Reference
    private VideoService videoService;
    @Reference
    private MemberService memberService;

    //TODO
    //* 实现思路:
    //* 1. 前端传入member_id, video_id
    //* 2. 通过member_id, 查DB拿到card_id (member_id可能不合法,报错 / 没开VIP的话, card_id可能不存在,返回提示开通VIP )
    //* 3. 通过card_id, 查DB拿到video_id_list, 遍历list, 看是否有和传入的video_id相同的id
    //*     3.1 如果存在, 通过这个video_id 查DB拿到url & name 等信息, 返回给前端, 是否返回整个页面还未确定, 需要和阳一鸣沟通
    //*     3.2 如果不存在, 返回: 权限不够, 请买课/买VIP

    @RequestMapping("/get")
    public String getVideo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long video_id = Long.parseLong(request.getParameter("video_id"));
        String member_id = request.getParameter("member_id");
        boolean has_video = false;
        if (member_id != null) {
            //验证用户是否存在
            GymMember member = memberService.findById(member_id);
            if (member != null) {
                Map<String, Object> add_success = new HashMap<>();
                add_success.put("video_error", "no such a user");
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(objectMapper.writeValueAsString(add_success));
                System.out.println("user_error : no such a user");
                return "getVideo";
            }

            //判断是否为vip
            String card_id = member.getCardId();
            if (card_id != null) {
                Map<String, Object> add_success = new HashMap<>();
                add_success.put("video_error", "you are not vip");
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(objectMapper.writeValueAsString(add_success));
                System.out.println("vip_error : you are not vip");
                return "getVideo";
            }

            //查询VIP的video list
            if (videoService.getVideoList(card_id).size() == 0) {
                Map<String, Object> add_success = new HashMap<>();
                add_success.put("video_error", "no video provided");
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(objectMapper.writeValueAsString(add_success));
                System.out.println("video_warning : no video provided");
                return "getVideo";
            }
            List<Long> video_list = videoService.getVideoList(card_id);

            //查询请求的视频是否可观看
            for (Long v_id : video_list) {
                if (video_id == v_id) {
                    has_video = true;
                    break;
                }
            }
            if (!has_video) {
                Map<String, Object> add_success = new HashMap<>();
                add_success.put("video_error", "video forbidden");
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(objectMapper.writeValueAsString(add_success));
                System.out.println("video_forbidden : yes");
                return "getVideo";
            }
        }
        //获取video信息
        try {
            GymVideo select_video = videoService.getVideo(video_id);
            if (select_video.getPrice() == 0 || has_video) { // 视频免费(登录与否都可看) or 用户有VIP
                Map<String, Object> add_success = new HashMap<>();
                add_success.put("video", select_video);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(objectMapper.writeValueAsString(add_success));
                return "video";  // 暂时未实现
            } else if (select_video.getPrice() != 0 && !has_video) { //非vip看付费视频
                Map<String, Object> add_success = new HashMap<>();
                add_success.put("video_error", "video forbidden");
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(objectMapper.writeValueAsString(add_success));
                System.out.println("video_forbidden : yes");
                return "getVideo";
            }
        } catch (Exception e) {
            Map<String, Object> add_success = new HashMap<>();
            add_success.put("video_error", "no video provided");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(add_success));
            System.out.println("video_warning : no video provided");
            return "getVideo";
        }
        return "getVideo";
    }

    @RequestMapping("buy")
    public Map<String,Object> buyVideo(@RequestBody GymMember member, @RequestBody GymVideo video) {
        //! 写db
        try {
            videoService.updateCardVideo(member.getCardId(), video.getId());
        } catch (Exception e) {
            Map<String,Object> add_error = new HashMap<>();
            add_error.put("vip_error", "发生未知错误，添加数据库失败");
            add_error.put("address", "vip");
            return add_error;
        }
        Map<String,Object> add_success = new HashMap<>();
        add_success.put("vip_data", "\"购买VIP成功! 会员ID:\" + card_id");
        add_success.put("address", "home");
        return add_success;
    }

}
