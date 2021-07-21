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
    @Reference(version = "1.0.0", url = "dubbo://localhost:20887?version=1.0.0")
    private LoginService loginService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private MemberService memberService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20889?version=1.0.0")
    private RedisService redisService;

    @RequestMapping("/check")
    public Map<String, Object> check(@RequestBody String phone) throws IOException {
        Map<String, Object> data = new HashMap<>();
        GymMember member = memberService.findByPhone(phone);
        if (member != null) {
            data.put("member", member);
            return data;
        }
        data.put("member", null);
        return data;
    }

    @RequestMapping("/register")
    public Map<String, Object> register(@RequestBody GymMember member, HttpServletResponse response) {
        Map<String, Object> data = new HashMap<>();
        if (loginService.register(member, response)) {
            redisService.set("gymMember" + "@" + member.getPhone(), member.getPasswd());
            data.put("address", "index");
        } else {
            data.put("address", "register");
        }
        return data;
    }

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody GymMember member, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> data = new HashMap<>();
//        String p = request.getParameter("phone");
//        String pp = request.getParameter("passwd");
        if (loginService.login(request, response)) {
            redisService.set("gymMember" + "@" + member.getPhone(), member.getPasswd());
            data.put("address", "index");
        } else {
            data.put("address", "login");
        }
        return data;
    }

    @RequestMapping("/logout")
    public Map<String, Object> logout(String phone, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> data = new HashMap<>();
        loginService.logout(phone, request, response);
        redisService.del("gymMember" + "@" + phone);
        data.put("address", "index");
        return data;
    }
}
