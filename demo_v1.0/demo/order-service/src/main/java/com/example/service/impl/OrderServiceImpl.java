package com.example.service.impl;

import com.example.mapper.GymOrdersMapper;
import com.example.pojo.GymOrders;
import com.example.pojo.GymOrdersExample;
import com.example.service.OrderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service(version ="1.0.0")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private GymOrdersMapper gymOrdersMapper;

    @Override
    public GymOrders findOrdersById(String id) {
        return gymOrdersMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GymOrders> findOrdersByStatus(String phone, Integer s) {
        GymOrdersExample example = new GymOrdersExample();
        example.createCriteria()
                .andIdLike("%"+phone+"%")
                .andIfUsedEqualTo(s);
        return gymOrdersMapper.selectByExample(example);
    }

    @Override
    public boolean deleteOrderById(GymOrders orders) {
        GymOrdersExample example = new GymOrdersExample();
        example.createCriteria()
                .andIdEqualTo(orders.getId())
                .andClassVideoEqualTo(orders.getClassVideo())
                .andCreateTimeEqualTo(orders.getCreateTime())
                .andPriceEqualTo(orders.getPrice());
        try {
            gymOrdersMapper.deleteByExample(example);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insertOrders(GymOrders order) {
        try {
            gymOrdersMapper.insert(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int updateOrders(GymOrders order) {
        return gymOrdersMapper.updateByPrimaryKey(order);
    }

    @Override
    public boolean ifOrderUsed(GymOrders order) {
        return order.getIfUsed() == 0;
    }

    @Override
    public boolean ifOrderPayed(GymOrders order) {
        return order.getIfUsed() == 1;
    }
}
