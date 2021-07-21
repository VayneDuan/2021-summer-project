package com.example.service;

import com.example.pojo.GymOrders;

public interface AlipayService {
    String pay(String outTradeNo, String amount, String return_url) throws Exception;

    String refund(GymOrders order);
}
