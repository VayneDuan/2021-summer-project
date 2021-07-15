package com.example.demo.alipay.service;

import java.math.BigDecimal;

public interface AlipayService {

    /**
     * 生成支付表单
     */
    public String toPay(String subject, BigDecimal money) throws Exception;

    /**
     * 查询交易状态
     */
    public Object queryTradeStatus(String outTradeNo) throws Exception;

}
