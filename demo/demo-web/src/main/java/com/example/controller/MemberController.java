package com.example.controller;

import com.example.pojo.GymMember;
import com.example.service.MemberService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Reference
    private MemberService memberService;

    // @RequestMapping("/select/{phone}") 不支持
    @RequestMapping("/selectByPhone")
    @ResponseBody
    public GymMember findByPhone(String phone) {
        return memberService.findByPhone(phone);
    }

    @RequestMapping("/updateName")
    public GymMember changeMemberName(String name, HttpServletRequest request) {
        // 验证用户是否登录
        String phone = request.getParameter("phone");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals(phone)) {
                    // RedisUtil.getSession()
                    // 验证cookie与session是否一致
                    // if (一致) break; else return;
                }
            }
        } else {
            // return
        }
        memberService.changeMemberName(phone, name);
        return memberService.findByPhone(phone);
    }
}
