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
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private EmpService empService;

    @RequestMapping("/add")
    public Map<String, Object> addOrders(@RequestBody Map<String, Object> req) {
        GymOrders order = new GymOrders();
        LinkedHashMap<String, Object> gymClass = (LinkedHashMap<String, Object>) req.get("class");
        order.setClassVideo((Integer) req.get("class_video"));
        order.setCvId(Long.valueOf((gymClass.get("id").toString())));
        order.setPrice((Integer) gymClass.get("price"));
        Map<String, Object> add_orders = new HashMap<>();
        String phone = (String) req.get("phone");
        GymMember member = memberService.findByPhone(phone);
        Date createTime = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(createTime);
        // 通过System.currentTimeMillis()来获取一个当前时间毫秒数的long型数字
//        order.setId(tradeNo+"@"+System.currentTimeMillis()+"@"+member.getPhone());
        order.setId(System.currentTimeMillis()+"@"+member.getPhone());
        order.setCardId(member.getCardId());
        order.setCreateTime(createTime);
        order.setIfUsed(2);
        try {
            orderService.insertOrders(order);
            add_orders.put("add_order", "success");
        } catch (Exception e) {
            add_orders.put("add_order", "error");
        }
        return add_orders;
    }

    @RequestMapping("/get")
    // 教练名，课程名，单价, id
    public Map<String, Object> getOrders(@RequestBody Map<String, Object> req) {
        Map<String, Object> get_orders = new HashMap<>();
        String phone = (String) req.get("phone");
        List<GymOrders> orders = orderService.findOrdersByStatus(phone, 2);
        List<List<String>> orders_info = new ArrayList<>();
        for (GymOrders order : orders) {
            Long cv_id = order.getCvId();
            List<String> order_info = new ArrayList<>();
            GymClass gymClass = classService.findById(cv_id);
            order_info.add(gymClass.getGymClassName());
            order_info.add(empService.findById(gymClass.getEmpId()).getGymEmpName());
            order_info.add(gymClass.getPrice().toString());
            order_info.add(order.getId());
            orders_info.add(order_info);
        }
        get_orders.put("data", orders_info);
        return get_orders;
    }

    @RequestMapping("/pay")
    public Map<String, Object> payOrders(@RequestBody Map<String, Object> req) {
        List<String> orders = (List<String>) req.get("list");
        Map<String, Object> pay_orders = new HashMap<>();
        Integer sumPrice = 0;
        String phone = (String) req.get("phone");
        GymMember member = memberService.findByPhone(phone);
        String tradeNo = UUID.randomUUID().toString();
//        String tradeNo = orders.get(0).getId().split("@")[0];
        for (String order_id : orders) {
            GymOrders order = orderService.findOrdersById(order_id);
            order.setId(tradeNo+"@"+order.getId());
            // 通过System.currentTimeMillis()来获取一个当前时间毫秒数的long型数字
            order.setIfUsed(1);
            orderService.updateOrders(order);
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
        pay_orders.put("tradeNo", tradeNo);
        pay_orders.put("sumPrice", sumPrice);
        pay_orders.put("address", "localhost:8080/pay");
        return pay_orders;
    }
}
