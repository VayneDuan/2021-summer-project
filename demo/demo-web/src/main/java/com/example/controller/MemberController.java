package com.example.controller;

import com.example.pojo.GymMember;
import com.example.service.MemberService;
import com.example.service.PictureService;
import com.example.service.RedisService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private MemberService memberService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20889?version=1.0.0")
    private RedisService redisService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20897?version=1.0.0")
    private PictureService pictureService;

    @RequestMapping("/selectByPhone")
    public Map<String, Object> findByPhone(@RequestBody Map<String, Object> req) {
        String phone = (String) req.get("phone");
        Map<String, Object> data = new HashMap<>();
        data.put("member", memberService.findByPhone(phone));
        return data;
    }

    @RequestMapping("/updateName")
    public Map<String, Object> changeMemberName(@RequestBody Map<String, Object> req, HttpServletRequest request) {
        String name = (String) req.get("name");
        // 验证用户是否登录
        Map<String, Object> data = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies) {
                // 有cookie
                if (cookie.getName().split("@")[0].equals("gymMember")) {
                    String phone = cookie.getName().split("@")[1];
                    GymMember member = memberService.findByPhone(phone);
                    String val = (String) redisService.get(phone);
                    // cookie被修改，需要重新登录
                    if (!val.equals(member.getPasswd())) {
                        data.put("change_name", "error");
                        data.put("address", "login");
                    } else {
                        memberService.changeMemberName(phone, name);
                        data.put("change_name", "success");
                        data.put("data", memberService.findByPhone(phone));
                    }
                    return data;
                }
            }
        }
        data.put("change_name", "error");
        data.put("address", "login");
        return data;
    }

    @RequestMapping("/updatePasswd")
    public Map<String, Object> changeMemberName(@RequestBody Map<String, Object> req) {
        Map<String, Object> data = new HashMap<>();
        String phone = (String) req.get("phone");
        String newPasswd = (String) req.get("new_passwd");
        try {
            memberService.changePasswd(phone, newPasswd);
            data.put("msg", "success");
        } catch (Exception e) {
            data.put("msg", "failure");
        }
        return data;
    }

    @RequestMapping("/uploadPic")
    public Map<String, Object> uploadPic(@RequestBody Map<String, Object> req) {
        Map<String, Object> data = new HashMap<>();
        String picUrl = (String) req.get("pic_url");
        try {
            String fastUrl = pictureService.uploadPic(picUrl);
            data.put("fast_url", fastUrl);
        } catch (Exception e) {
            data.put("fast_url", null);
        }
        return data;
    }
}
