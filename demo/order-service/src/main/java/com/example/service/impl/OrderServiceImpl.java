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
    public List<GymOrders> findOrdersById(String id) {
        GymOrdersExample example = new GymOrdersExample();
        example.createCriteria().andIdEqualTo(id);
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
    public boolean insertOrders(List<GymOrders> orders, long cv_id, String card_id) {
        try {
            for (GymOrders order : orders) {
                order.setId(UUID.randomUUID().toString());
                order.setCvId(cv_id);
                order.setCardId(card_id);
                Date beginDate = new Date();
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(beginDate);
                beginDate = calendar.getTime();
                order.setCreateTime(beginDate);
                order.setIfUsed(1);
                gymOrdersMapper.insert(order);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean ifOrderUsed(GymOrders order) {
        return order.getIfUsed() == -1;
    }

    @Override
    public boolean ifOrderPayed(GymOrders order) {
        return order.getIfUsed() == 0;
    }
}
