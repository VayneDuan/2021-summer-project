package com.example.demo.web.controller;

import com.example.demo.result.RpcResult;
import com.example.demo.service.OrderDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderConsumerController {
    @Reference
    OrderDubboService orderDubboService;

    @GetMapping("/getOrder")
    public RpcResult getOrder() {
        return orderDubboService.getOrder();
    }
}
