package com.example.service;

import com.example.pojo.GymOrders;

import java.util.List;

public interface OrderService {
    GymOrders findOrdersById(String id);

    List<GymOrders> findOrdersByStatus(String phone, Integer s);

    boolean deleteOrderById(GymOrders order);

    boolean insertOrders(GymOrders order);

    int updateOrders(GymOrders order);

    // 判断订单内容（视频，课程）是否使用
    boolean ifOrderUsed(GymOrders order);

    // 判断订单是否支付
    boolean ifOrderPayed(GymOrders order);
}
