package com.example.controller;

import com.example.pojo.GymCard;
import com.example.pojo.GymMember;
import com.example.pojo.GymOrders;
import com.example.service.AlipayService;
import com.example.service.MemberService;
import com.example.service.OrderService;
import com.example.service.VipService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/vip")
public class VipController {
    @Reference(version = "1.0.0", url = "dubbo://localhost:20890?version=1.0.0")
    private VipService vipService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20894?version=1.0.0")
    private AlipayService alipayService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private MemberService memberService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20893?version=1.0.0")
    private OrderService orderService;

    @RequestMapping("buy")
    public Map<String, Object> buyVip(@RequestBody GymCard card, HttpServletRequest request) {
        // 前端可以传这个吗？
//        String member_id = request.getParameter("member_id");
//        Integer if_times = Integer.parseInt(request.getParameter("if_times"));
//        Integer card_level = Integer.parseInt(request.getParameter("card_level"));
//        Double amount = Double.parseDouble(request.getParameter("amount"));

        Date beginDate = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(beginDate);
        Date endDate = new Date();

        //! level 1,2,3     if_times 0,1
        if (card.getAmount() < 0 || card.getCardLevel() < 1 || card.getCardLevel() > 3 ||
                (card.getIfTimes() != 1 && card.getIfTimes() != 0)) {
            //! 参数错误
            System.out.println("[ERROR] arg wrong");
            Map<String,Object> data = new HashMap<>();
            data.put("vip_error", "参数错误");
            data.put("address", "vip");
            return data; // TODO 前端弹窗提示错误信息？或者跳转到错误页面
        }

        //! 根据 if_times 判断是不是次卡, 设置amount, 生成endTime
        //! 在video 服务, 根据if_times 来判断 校验对象是 endTime or amount
        if (card.getIfTimes() == 1) {
            //! 是次卡的话, endTime 是100年后
            calendar.add(Calendar.YEAR, 100); //把日期往后增加 100 年，整数往后推，负数往前移
            endDate = calendar.getTime();
        } else {
            //! 年卡
            calendar.add(Calendar.YEAR, 1); //把日期往后增加 1 年，整数往后推，负数往前移
            endDate = calendar.getTime();
        }

        //! 生成随机card_id (随机数字字符串)
        String card_id = UUID.randomUUID().toString();

        //! 设置card, 准备写DB
        card.setId(card_id);
        card.setBegintime(beginDate);
        card.setEndtime(endDate);
        if (card.getIfTimes() != 1) {
            card.setAmount(-1.);
        }

        String phone = request.getParameter("phone");
        Integer price = Integer.parseInt(request.getParameter("price"));
        GymMember member = memberService.findByPhone(phone);
        // 创建订单
        GymOrders order = new GymOrders();
        String tradeNo = UUID.randomUUID().toString();
        order.setId(tradeNo+"@"+System.currentTimeMillis());
        order.setClassVideo(2);
        order.setCreateTime(beginDate);
        order.setPrice(price);
        order.setIfUsed(1);
        orderService.insertOrders(order);
        //! 写db
        try {
            vipService.add(card);
        } catch (Exception e) {
            Map<String,Object> add_error = new HashMap<>();
            add_error.put("vip_error", "发生未知错误，添加数据库失败");
            add_error.put("address", "vip");
            return add_error; // TODO 前端弹窗提示错误信息？或者跳转到错误页面
        }

        //! card_id -> gym_member , 更新db
        vipService.updateVipStatus(member, card.getId());

        System.out.println("插入VIP数据成功");
        Map<String,Object> add_success = new HashMap<>();
        add_success.put("vip_data", "\"购买VIP成功! 会员ID:\" + card_id");
        add_success.put("address", "home");
        return add_success; // TODO 返回到用户个人中心
    }
}
