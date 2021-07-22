package com.example.controller;

import com.example.pojo.GymOrders;
import com.example.service.AlipayService;
import com.example.service.MemberService;
import com.example.service.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AlipayController {
    @Reference(version = "1.0.0", url = "dubbo://localhost:20894?version=1.0.0")
    private AlipayService alipayService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20893?version=1.0.0")
    private OrderService orderService;
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private MemberService memberService;

//    @RequestMapping("/pay")
//    public Map<String, Object> pay(@RequestBody List<GymOrders> orders, HttpServletRequest request) throws Exception {
//        Map<String, Object> payResult = new HashMap<>();
//        String return_url = "http://localhost:8080";
//        if (orders.get(0).getClassVideo() == 2) {
//            // 购买会员
//            return_url += "/vip/buy";
//            String payBody = null;
//            for (GymOrders order : orders) {
//                payBody = alipayService.pay(order.getId(), order.getPrice().toString(), return_url);
//            }
//            payResult.put("pay_body", payBody);
//        } else {
//            long cv_id = Long.parseLong(request.getParameter("cv_id"));
//            String phone = request.getParameter("phone");
//            String card_id = memberService.findByPhone(phone).getCardId();
//            if (orders.get(0).getClassVideo() == 1) {
//                // 购买视频
//                return_url += "/videos/buy";
//                String payBody = null;
//                for (GymOrders order : orders) {
//                    payBody = alipayService.pay(order.getId(), order.getPrice().toString(), return_url);
//                }
//                orderService.insertOrders(orders, cv_id, card_id);
//                payResult.put("pay_body", payBody);
//            } else if (orders.get(0).getClassVideo() == 0) {
//                // 购买课程
//                return_url += "/classes/buy";
//                String payBody = null;
//                for (GymOrders order : orders) {
//                    payBody = alipayService.pay(order.getId(), order.getPrice().toString(), return_url);
//                }
//                orderService.insertOrders(orders, cv_id, card_id);
//                payResult.put("pay_body", payBody);
//            } else {
//                payResult.put("pay_error", "payment failed");
//            }
//        }
//        return payResult;
//    }

    @RequestMapping("/pay")
    public String pay(String outTradeNo, String amount, String return_url, Integer if_vip) throws Exception {
        String res = alipayService.pay("20210722193613260", "9.99", "http://localhost:8080");
        if (if_vip == 1) {
            alipayService.pay(outTradeNo, amount, "http://localhost:8080/vip/buy");
        } else {
            alipayService.pay(outTradeNo, amount, return_url);
        }
        return res;
    }

    @RequestMapping("/refund")
    public String refund(@RequestBody Map<String, Object> req) {
        GymOrders order = (GymOrders) req.get("order");
        return alipayService.refund(order);
    }

//    @RequestMapping("/refund")
//    public String refund(GymOrders order) {
//        return alipayService.refund(order);
//    }
}
