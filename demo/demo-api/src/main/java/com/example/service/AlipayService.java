package com.example.service;

import com.example.pojo.GymOrders;

import java.util.List;

public interface AlipayService {
    String pay(String outTradeNo, String amount, String return_url) throws Exception;

    public String refund(GymOrders order);
//    String refund(GymOrders order);
}
