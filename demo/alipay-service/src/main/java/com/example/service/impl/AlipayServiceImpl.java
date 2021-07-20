package com.example.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.example.pojo.GymOrders;
import com.example.service.AlipayService;
import org.apache.dubbo.config.annotation.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version ="1.0.0")
public class AlipayServiceImpl implements AlipayService {
    @Override
    public String pay(String outTradeNo, String amount, String return_url) throws Exception {
        try {
            AlipayTradePagePayResponse pay = Factory.Payment.Page()
                    .pay("payment", outTradeNo, amount, return_url);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }

    @Override
    public String refund(GymOrders order) {
        return "refund_success";
    }

//    @Override
//    public String refund(GymOrders order) {
//        try {
//            AlipayTradeRefundResponse response = Factory.Payment.Common()
//                    .refund(order.getId(), order.getPrice().toString());
//            if (ResponseChecker.success(response)) {
//                return "success";
//            } else {
//                return "failed";
//            }
//        } catch (Exception e) {
//            return "failed";
//        }
//    }
}
