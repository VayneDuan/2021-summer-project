package com.example.controller;

import com.example.pojo.GymClass;
import com.example.pojo.GymMember;
import com.example.pojo.GymOrders;
import com.example.service.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private EmpService empService;

    @RequestMapping("/selectByName")
    public Map<String, Object> findByName(@RequestBody Map<String, Object> req) {
        Map<String, Object> data = new HashMap<>();
        data.put("class_list", classService.findByName((String) req.get("className")));
        return data;
    }

    @RequestMapping("all")
    public Map<String, Object> findAllOrderedByDays() {
        Map<String, Object> data = new HashMap<>();
        Map<Integer, List<GymClass>> classesOrderedByDays = new HashMap<>();
        Map<Integer, List<List<String>>> str = new HashMap<>();
        for (int i=1;i<=7;i++) {
            classesOrderedByDays.put(i, new ArrayList<GymClass>());
            str.put(i, new ArrayList<List<String>>());
        }
        try {
            List<GymClass> classes = classService.findAllWithCoach();
            for (GymClass gymClass : classes) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                classesOrderedByDays.get(gymClass.getClassWeek()).add(gymClass);
                List<String> s = new ArrayList<>();
                s.add(empService.findById(gymClass.getEmpId()).getGymEmpName());
                s.add(sdf.format(gymClass.getBegintime()));
                s.add(sdf.format(gymClass.getEndtime()));
                str.get(gymClass.getClassWeek()).add(s);
            }
        } catch (Exception e) {
            data.put("msg", e.getMessage());
            data.put("all_class", null);
            return data;
        }
        data.put("all_class", classesOrderedByDays);
        data.put("coaches", str);
        return data;
    }

//    @RequestMapping("/buy")
//    public Map<String, Object> buyClass(@RequestBody Map<String, Object> req) {
//        String phone = (String) req.get("phone");
//        GymClass gymClass = (GymClass) req.get("gymClass");
//        GymMember member = memberService.findByPhone(phone);
//        Date createTime = new Date();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(createTime);
//        //! 写db
//        try {
//            classService.updateCardClass(member.getCardId(), gymClass.getId());
//        } catch (Exception e) {
//            Map<String, Object> add_error = new HashMap<>();
//            add_error.put("vip_error", "发生未知错误，添加数据库失败");
//            add_error.put("address", "localhost:8080/vip");
//            return add_error;
//        }
//
//        Map<String, Object> add_success = new HashMap<>();
//        add_success.put("vip_data", "购买VIP成功! 会员ID: " + member.getCardId());
//        add_success.put("address", "home");
//        return add_success;
//    }

}
