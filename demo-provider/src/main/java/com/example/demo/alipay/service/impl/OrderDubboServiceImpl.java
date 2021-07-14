package com.example.demo.service.impl;

import com.example.demo.result.RpcResult;
import com.example.demo.service.OrderDubboService;
import com.example.demo.pojo.OrderDomain;
import org.apache.dubbo.config.annotation.Service;

import java.time.LocalDateTime;

@Service
public class OrderDubboServiceImpl implements OrderDubboService {

    @Override
    public RpcResult<OrderDomain> getOrder() {
        return RpcResult.success(new OrderDomain(1, 10086, LocalDateTime.now()));
    }
}
