package com.example.demo.service;

import com.example.demo.domain.OrderDomain;
import com.example.demo.result.RpcResult;

public interface OrderDubboService {
    RpcResult<OrderDomain> getOrder();
}
