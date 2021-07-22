package com.example.service;

import com.example.pojo.GymMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    boolean register(GymMember member);

    boolean login(String phone, String passwd);

//    void logout(String phone, HttpServletRequest request, HttpServletResponse response);
}
