package com.example.service.impl;

import com.example.mapper.GymMemberMapper;
import com.example.pojo.GymMember;
import com.example.pojo.GymMemberExample;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;

@Service(version ="1.0.0")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private GymMemberMapper gymMemberMapper;

    @Override
    public GymMember findByPhone(String phone) {
        GymMemberExample example = new GymMemberExample();
        example.createCriteria().andPhoneEqualTo(phone);
        if (gymMemberMapper.selectByExample(example).size() > 0) {
            return gymMemberMapper.selectByExample(example).get(0);
        } else
            return null;
    }

    @Override
    public void changeMemberName(String phone, String newName) {
        GymMember member = findByPhone(phone);
        member.setGymMemberName(newName);
        gymMemberMapper.updateByPrimaryKey(member);
    }

    @Override
    public GymMember findById(String id) {
        return gymMemberMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateCoach(String phone, Long coach_id) {
        GymMember member = findByPhone(phone);
        member.setCoachId(coach_id);
        gymMemberMapper.updateByPrimaryKey(member);
    }
}
