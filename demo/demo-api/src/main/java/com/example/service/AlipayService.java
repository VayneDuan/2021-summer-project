package com.example.service;

import com.example.pojo.GymOrders;

import java.util.Map;

public interface AlipayService {
    String pay(String outTradeNo, String amount, String return_url) throws Exception;

    String refund(GymOrders order);
}
