package com.example.controller;

import com.example.pojo.GymMember;
import com.example.service.LoginService;
import com.example.service.MemberService;
import com.example.service.RedisService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Reference
    private LoginService loginService;
    @Reference
    private MemberService memberService;
    @Reference
    private RedisService redisService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> data = new HashMap<>();
        // 先检验是否有cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if (cookie.getName().split("@")[0].equals("gymMember")) {
                String phone = cookie.getName().split("@")[1];
                GymMember member = memberService.findByPhone(phone);
                if (member != null) {
                    data.put("member", member);
                    response.setContentType("application/json;charset=utf-8");
                    ObjectMapper objectMapper = new ObjectMapper();
                    response.getWriter().write(objectMapper.writeValueAsString(data));
                }
                break;
            }
        }
        return "index";
    }

    @RequestMapping("/register")
    public String register(@RequestBody GymMember member, HttpServletResponse response) {
        if (loginService.register(member, response)) {
            redisService.set("gymMember"+"@"+member.getPhone(), member.getPasswd());
            return "index";
        } else {
            return "register";
        }
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        if (loginService.login(request, response)) {
            redisService.set("gymMember"+"@"+request.getParameter("phone"), request.getParameter("passwd"));
            return "index";
        } else
            return "login";
    }

    @RequestMapping("/logout")
    public String logout(String phone, HttpServletRequest request, HttpServletResponse response) {
        loginService.logout(phone, request, response);
        redisService.del("gymMember"+"@"+phone);
        return "index";
    }
}
