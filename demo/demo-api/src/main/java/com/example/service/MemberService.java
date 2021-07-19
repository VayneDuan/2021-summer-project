package com.example.service;

import com.example.pojo.GymMember;

public interface MemberService {
    GymMember findByPhone(String phone);
    int changeMemberName(String phone, String newName);
    GymMember findById(String id);
}
