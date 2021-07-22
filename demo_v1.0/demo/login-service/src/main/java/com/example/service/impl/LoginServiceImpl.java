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
    public boolean register(GymMember member) {
        try {
            gymMemberMapper.insert(member);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean login(String phone, String passwd) {
        GymMemberExample example = new GymMemberExample();
        example.createCriteria().andPhoneEqualTo(phone);
        GymMember member = gymMemberMapper.selectByExample(example).get(0);
        if (member == null) return false;
        if (!member.getPasswd().equals(passwd)) {
            return false;
        } else {
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
