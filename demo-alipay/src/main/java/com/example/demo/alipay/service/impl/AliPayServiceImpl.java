package com.example.demo.alipay.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeQueryResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.example.demo.alipay.service.AlipayService;
import com.example.demo.alipay.util.JSONUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class AliPayServiceImpl implements AlipayService {
    @Override
    public String toPay(String subject, BigDecimal money) throws Exception {
        AlipayTradePagePayResponse pay = Factory.Payment.Page().pay(subject, this.generateTradeNo(),
                String.valueOf(money), "http://localhost:8080");
        String payForm = null;
        if (ResponseChecker.success(pay)) {
            payForm = pay.getBody();
        }
        return payForm;
    }

    /**
     * 通过时间生成外部订单号 out_trade_no
     * @return
     */
    private String generateTradeNo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String tradeNo = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        System.out.println(tradeNo);
        return tradeNo;
    }

    @Override
    public Object queryTradeStatus(String outTradeNo) throws Exception {
        AlipayTradeQueryResponse query = Factory.Payment.Common().query(outTradeNo);
        Map<String, Object> map = JSONUtils.jsonToMap(query.getHttpBody());
        // 返回交易结果, 是否交易成功需要根据该对象中的 trade_status 来确定
        // trade_status 的枚举值如下, 请见 https://opendocs.alipay.com/apis/api_1/alipay.trade.query
        // WAIT_BUYER_PAY（交易创建，等待买家付款）
        // TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）
        // TRADE_SUCCESS（交易支付成功）
        // TRADE_FINISHED（交易结束，不可退款）
        // 当 trade_status 等于 TRADE_SUCCESS 或 TRADE_FINISHED 时, 表示支付成功
        return map.get("alipay_trade_query_response");
    }
}
