package com.example.service;

import com.example.pojo.GymOrders;

import java.util.List;

public interface OrderService {
    List<GymOrders> findOrdersById(String id);

    boolean deleteOrderById(GymOrders order);

    boolean insertOrders(List<GymOrders> orders, long cv_id, String card_id);

    // 判断订单内容（视频，课程）是否使用
    boolean ifOrderUsed(GymOrders order);

    // 判断订单是否支付
    boolean ifOrderPayed(GymOrders order);
}
