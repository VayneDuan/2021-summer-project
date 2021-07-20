package com.example.controller;

import com.example.pojo.GymClass;
import com.example.pojo.GymMember;
import com.example.service.ClassService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Reference(version = "1.0.0", url = "dubbo://localhost:20892?version=1.0.0")
    private ClassService classService;

    @RequestMapping("/selectByName")
    @ResponseBody
    public Map<String, Object> findByName(String className) {
        Map<String, Object> data = new HashMap<>();
        data.put("class_list", classService.findByName(className));
        return data;
    }

    @RequestMapping("/buy")
    public Map<String, Object> buyClass(@RequestBody GymMember member, @RequestBody GymClass gymClass) {
        // 前端可以传这个吗？
//        String member_id = request.getParameter("member_id");
//        Integer if_times = Integer.parseInt(request.getParameter("if_times"));
//        Integer card_level = Integer.parseInt(request.getParameter("card_level"));
//        Double amount = Double.parseDouble(request.getParameter("amount"));

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
        add_success.put("vip_data", "\"购买VIP成功! 会员ID:\" + card_id");
        add_success.put("address", "home");
        return add_success;
    }
}
