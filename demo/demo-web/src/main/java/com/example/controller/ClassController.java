package com.example.controller;

import com.example.pojo.GymClass;
import com.example.pojo.GymMember;
import com.example.pojo.GymOrders;
import com.example.service.AlipayService;
import com.example.service.ClassService;
import com.example.service.MemberService;
import com.example.service.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Reference(version = "1.0.0", url = "dubbo://localhost:20892?version=1.0.0")
    private ClassService classService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private MemberService memberService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20894?version=1.0.0")
    private AlipayService alipayService;

    @RequestMapping("/selectByName")
    @ResponseBody
    public Map<String, Object> findByName(String className) {
        Map<String, Object> data = new HashMap<>();
        data.put("class_list", classService.findByName(className));
        return data;
    }

    @RequestMapping("/buy")
    public Map<String, Object> buyClass(@RequestBody GymClass gymClass, HttpServletRequest request) {
        String phone = request.getParameter("phone");
        GymMember member = memberService.findByPhone(phone);
        Date createTime = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(createTime);
        //! 写db
        try {
            classService.updateCardClass(member.getCardId(), gymClass.getId());
        } catch (Exception e) {
            Map<String, Object> add_error = new HashMap<>();
            add_error.put("vip_error", "发生未知错误，添加数据库失败");
            add_error.put("address", "vip");
            return add_error;
        }

        Map<String, Object> add_success = new HashMap<>();
        add_success.put("vip_data", "购买VIP成功! 会员ID: " + member.getCardId());
        add_success.put("address", "home");
        return add_success;
    }
}
