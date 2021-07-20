package com.example.service.impl;

import com.example.mapper.GymMemberMapper;
import com.example.pojo.GymMember;
import com.example.pojo.GymMemberExample;
import com.example.service.LoginService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service(version ="1.0.0")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private GymMemberMapper gymMemberMapper;

    @Override
    public boolean register(GymMember member, HttpServletResponse response) {
        try {
            gymMemberMapper.insert(member);
        } catch (Exception e) {
            return false;
        }
        Cookie cookie = new Cookie("gymMember"+"@"+member.getPhone(), member.getPasswd());
        cookie.setMaxAge(12 * 60 * 60); // 12h 过期
        response.addCookie(cookie);
        return true;
    }

    @Override
    public boolean login(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        String passwd = request.getParameter("passwd");
        GymMemberExample example = new GymMemberExample();
        example.createCriteria().andPhoneEqualTo(phone);
        GymMember member = gymMemberMapper.selectByExample(example).get(0);
        if (member == null) return false;
        if (!member.getPasswd().equals(passwd)) {
            return false;
        } else {
            Cookie cookie = new Cookie("gymMember"+"@"+phone, passwd);
            cookie.setMaxAge(12 * 60 * 60); // 12h 过期
            response.addCookie(cookie);
            return true;
        }
    }

    @Override
    public void logout(String phone, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if (cookie.getName().split("@")[0].equals("gymMember")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
}
