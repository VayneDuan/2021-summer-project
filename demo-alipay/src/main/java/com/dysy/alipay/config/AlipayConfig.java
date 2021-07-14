package com.dysy.alipay.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.dysy.alipay.util.FileUtils;
import org.springframework.stereotype.Component;

@Component
public class AlipayConfig {

    // 1. 设置参数（全局只需设置一次）
    static {
        Factory.setOptions(getOptions());
    }

    private static Config getOptions() {
        Config config = new Config();

        config.protocol = "https";

        // 沙箱环境修改为 openapi.alipaydev.com
        config.gatewayHost = "openapi.alipaydev.com";

        config.signType = "RSA2";

        config.appId = "2021000117688663";

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = FileUtils.readFileOfTxt("D:\\重庆大学\\课程资料\\计算机专业课\\专业综合设计\\alipay\\应用私钥.txt");

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = FileUtils.readFileOfTxt("D:\\重庆大学\\课程资料\\计算机专业课\\专业综合设计\\alipay\\支付宝公钥.txt");

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = "";

        return config;
    }
}
