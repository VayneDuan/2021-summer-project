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
    public Map<String, Object> check(@RequestBody Map<String, Object> req) throws IOException {
        Map<String, Object> data = new HashMap<>();
        String phone = (String) req.get("phone");
        if (phone == null) return null;
        String passwd = (String) req.get("passwd");
        GymMember member = memberService.findByPhone(phone);
        if (member != null) {
            if (!passwd.equals(redisService.get("gymMember@" + phone))) {
                data.put("member", null);
            } else {
                data.put("member", member);
            }
            return data;
        }
        data.put("member", null);
        return data;
    }

    @RequestMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, Object> req, HttpServletResponse response) {
        String phone = (String) req.get("phone");
        GymMember member = memberService.findByPhone(phone);
        Map<String, Object> data = new HashMap<>();
        if (loginService.register(member)) {
            data.put("cookie_key", "gymMember"+"@"+phone);
            data.put("cookie_value", member.getPasswd());
            redisService.set("gymMember" + "@" + member.getPhone(), member.getPasswd());
            data.put("address", "localhost:8080/index");
        } else {
            data.put("address", "localhost:8080/register");
            data.put("cookie_key", null);
        }
        return data;
    }

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> req) {
        Map<String, Object> data = new HashMap<>();
        String phone = (String) req.get("phone");
        String passwd = (String) req.get("passwd");
        try {
            if (loginService.login(phone, passwd)) {
                redisService.set("gymMember" + "@" + phone, passwd);
                data.put("address", "localhost:8080/index");
                data.put("cookie_key", "gymMember"+"@"+phone);
                data.put("cookie_value", passwd);
            } else {
                data.put("address", "localhost:8080/login");
                data.put("cookie_key", null);
            }
        } catch (Exception e) {
            data.put("address", "localhost:8080/login");
            data.put("cookie_key", null);
        }
        return data;
    }

    @RequestMapping("/logout")
    public Map<String, Object> logout(@RequestBody Map<String, Object> req) {
        String phone = (String) req.get("phone");
        Map<String, Object> data = new HashMap<>();
//        loginService.logout(phone, request, response);
        redisService.del("gymMember" + "@" + phone);
        data.put("address", "localhost:8080/index");
        return data;
    }
}
