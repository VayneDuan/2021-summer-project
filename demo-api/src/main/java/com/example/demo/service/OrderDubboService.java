package com.example.demo.alipay.service;

import com.example.demo.pojo.OrderDomain;
import com.example.demo.result.RpcResult;

public interface OrderDubboService {
    RpcResult<OrderDomain> getOrder();
}
