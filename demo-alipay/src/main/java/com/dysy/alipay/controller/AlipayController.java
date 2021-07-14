package com.dysy.alipay.controller;

import com.alipay.easysdk.factory.Factory;
import com.dysy.alipay.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Controller
@CrossOrigin
@RequestMapping("/pay")
public class AlipayController {
    @Autowired
    private AlipayService alipayService;

    @GetMapping("/topay")
    @ResponseBody
    public String toPay(String subject, BigDecimal money) throws Exception {
        return alipayService.toPay(subject, money);
    }

    @PostMapping("/callback")
    @ResponseBody
    public String notifyCallback(HttpServletRequest request) throws Exception {
        System.out.println("进入异步");
        String success = "success";
        String failure = "failure";

        // https://opendocs.alipay.com/open/54/00y8k9 新老版本说明中有异步通知的新版说明
        // 获取支付宝异步回调信息, 将其转为 Map<String, String>
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }

        // 新版 SDK 不用移除 sign_type
        // params.remove("sign_type");

        // 验签
        boolean signVerified = Factory.Payment.Common().verifyNotify(params);

        if(signVerified){ // 验签通过
            System.out.println("通过验签");
            return success;
        }else{ // 验签失败
            return failure;
        }
    }

    @GetMapping("/query")
    @ResponseBody
    public Object queryTradeStatus(String outTradeNo) throws Exception {
        Object result = alipayService.queryTradeStatus(outTradeNo);
        return result;
    }
}
