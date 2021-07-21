package com.example.controller;

import com.example.pojo.GymClass;
import com.example.pojo.GymMember;
import com.example.pojo.GymOrders;
import com.example.service.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Reference(version = "1.0.0", url = "dubbo://localhost:20893?version=1.0.0")
    private OrderService orderService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private MemberService memberService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20892?version=1.0.0")
    private ClassService classService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20891?version=1.0.0")
    private VideoService videoService;

    @RequestMapping("/pay")
    public Map<String, Object> payOrders(@RequestBody List<GymOrders> orders, HttpServletRequest request) {
        Map<String, Object> pay_orders = new HashMap<>();
        Integer sumPrice = 0;
        String phone = request.getParameter("phone");
        String tradeNo = UUID.randomUUID().toString();
        GymMember member = memberService.findByPhone(phone);
        Date createTime = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(createTime);
        for (GymOrders order : orders) {
            // 通过System.currentTimeMillis()来获取一个当前时间毫秒数的long型数字
            order.setId(tradeNo+"@"+System.currentTimeMillis());
            order.setCardId(member.getCardId());
            order.setCreateTime(createTime);
            order.setIfUsed(1);
            orderService.insertOrders(order);
            sumPrice += order.getPrice();
            if (order.getClassVideo() == 0) {
                classService.updateCardClass(member.getCardId(), order.getCvId());
                memberService.updateCoach(phone, classService.findById(order.getCvId()).getEmpId());
            } else if (order.getClassVideo() == 1) {
                videoService.updateCardVideo(member.getCardId(), order.getCvId());
            } else if (order.getClassVideo() == 2) {
                pay_orders.put("vip", true);
            } else {
                pay_orders.put("order", "error");
                return pay_orders;
            }
        }
        pay_orders.put("tradNo", tradeNo);
        pay_orders.put("sumPrice", sumPrice);
        pay_orders.put("address", "pay");
        return pay_orders;
    }
}
