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
//    @Reference(version = "1.0.0", url = "dubbo://localhost:20897?version=1.0.0")
//    private PictureService pictureService;

    @RequestMapping("/selectByPhone")
    public Map<String, Object> findByPhone(@RequestBody Map<String, Object> req) {
        String phone = (String) req.get("phone");
        String passwd = (String) req.get("passwd");
        Map<String, Object> data = new HashMap<>();
        GymMember member = memberService.findByPhone(phone);
        if (passwd.equals(member.getPasswd())) {
            data.put("member", member);
        } else {
            data.put("member", null);
        }
        return data;
    }

    @RequestMapping("/updateName")
    public Map<String, Object> changeMemberName(@RequestBody Map<String, Object> req) {
        String name = (String) req.get("name");
        String passwd = (String) req.get("passwd");
        // 验证用户是否登录
        Map<String, Object> data = new HashMap<>();
        String phone = (String) req.get("phone");
        // 有cookie
        try {
            String val = (String) redisService.get("gymMember" + "@" + phone);
            // cookie被修改，需要重新登录
            if (!val.equals(passwd)) {
                data.put("change_name", "error1");
                data.put("address", "localhost:8080/login");
            } else {
                memberService.changeMemberName(phone, name);
                data.put("change_name", "success");
                data.put("data", memberService.findByPhone(phone));
            }
            return data;
        } catch (Exception e) {
            data.put("change_name", "error2");
            data.put("address", "localhost:8080/login");
            return data;
        }
    }

    @RequestMapping("/updatePasswd")
    public Map<String, Object> changeMemberPasswd(@RequestBody Map<String, Object> req) {
        Map<String, Object> data = new HashMap<>();
        String phone = (String) req.get("phone");
        String oldPasswd = (String) req.get("oldPasswd");
        String newPasswd = (String) req.get("newPasswd");
        if (!oldPasswd.equals(redisService.get("gymMember@"+phone))) {
            data.put("msg", "error");
            return data;
        }
        try {
            memberService.changePasswd(phone, newPasswd);
            redisService.set("gymMember" + "@" + phone, newPasswd);
            data.put("msg", "success");
        } catch (Exception e) {
            data.put("msg", "error");
        }
        return data;
    }

    @RequestMapping("/uploadPic")
    public Map<String, Object> uploadPic(@RequestBody Map<String, Object> req) {
        Map<String, Object> data = new HashMap<>();
//        String picUrl = (String) req.get("pic_url");
//        try {
//            String fastUrl = pictureService.uploadPic(picUrl);
//            data.put("fast_url", fastUrl);
//        } catch (Exception e) {
//            data.put("fast_url", null);
//        }
        return data;
    }
}
