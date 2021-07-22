package com.example.service.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
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
        config.merchantPrivateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQD3DZvh4x18AQJAuOVm5GcOL3IB2AvcjuKLbtIlShwFwzxgzL1AH1WNMFV582/tni3KclV/UpHMfrzNSk4XPsQaJjjbPB4H6BipobHpOmY2Yu8QtFyjsO07nKB3A0z8NPonktxLrdHjLlgn3cgjEmBv+DBBRkVKTt8OAnPk4XAmnQ4OjvAYAP9jQZae6p+enUKGr/ZeUlqO205Z63K8xpEhksSqbm2Ra3WM2Rnftk043Xu0uxwi2uCQawFTMeZ7axtwmA98ZI71YsuUEcXXYtYanes9FQ6w1sCJVya4VRViY3TtTKPGGUzLLDuNAMWLrFnMCRqEHhDsG7PpNY8mUgvfAgMBAAECggEAe3nGxkBP9TE/4f9HUISpaTKXZYqIayTS32N1DoQau1qX672IfOrsRFO69OeRso5TTpKUXr1y92UEkgooO3/4XSVrV0+Vptf+s5GILQwuF9Kcr5mlj36XIysmHDV/HbKQsIS7K+vlMglwsAQtyjGeF3hRDd7ENN50pzjcmbF+7xymjQb2/KcA4EWP5FPzJAnD+JrMwIVZjcE5ARUr31yz/q+1jyvL4j+76CqHbvLO8syqUMt6yF3nK71/k9uapndwACCOrcoKrOVLjyP+lQK5XApguatzzHLQCdN/RJsFT9bxU2S1YJbsJNdga4jBSn9mNdNxqrLB9V+7AvdyK2ZLkQKBgQD8wEpKSYjtoiNC24J7L2Vl8COVCueL2vwqhpIT/kGBa/bfRcobJ+7g3p+cWrOEsRo23sNIl9mlbI04gSB4fmtXoQDaVgomCOOAISj/vkaIIbAwmKFl4IsfZj4EEWtf6cEBlMlS/pV2xq7JptHG0Fa3xsbvDQSJ9Gd6q5KstyPhiQKBgQD6OpGdmGaY7EvWDtwfRrfvk7yNgUNCiW1GvkjhKLKxoUZsOJMijokbpCGX5LwFjL6MIEnItjY/cwR8HZC75sVU8TOBaWfHWjZ/JUnIgVhHUrlfyyE7gWRkra4jmM2yyqRFMydz6HyV0HEeH9qAgAI6IkHOcV4YnjvCPCfRqckwJwKBgQClN61YUilH7SzPj14D2D+YGxmnW7FwIn2j7sOefh2j1EdUO/KZPclRBTWgp0mh+4L/Sy6sTVbgY80Mmpv3J+xTI9PC5WtM4ZKVNxft1RuV8S+TFLKsPdOzesofLqPZ1ptrxS61KeXZ9pZbCskmBRoql62CpifJZhIehfkjHbQ+wQKBgQC8v881XE8PzTZLKnxaT0LRwdP5vWaZ2wYF1eUtikB4gtmXKnm6GGBN7Fm2tMArQ4Y8NuLRNrjm1YCtirOxORrivuqGFJdGpcLz15G3X/HSIxFXs+bGdwzecLApg8qtsfOFi1eYM+c+LrQU8Bwmz+heJ5cR/SvoT/ttwWib24G6AwKBgQCyKK8zc1+8+MpW8svCHLDzC/sf1V1ESbLCuZBzyJL++EZ/dUPXXANvZW3kqOs2XslBzeq4sEhN9FJDXeMV359fsZwoPjm3sb+75s5LqhTU5eAa9GgHWKLpvIOSLiG+Vok0CR0sXP1w/CscAi4C5OjHiuVAkxyrEV3r6oDF+nHP2Q==";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgOLgTHULeEBqZ31IYrGNQmr4LjgWkjNhGhCuwviD+rYt3ZPSTrdd+6VdD1LVNyoG26B3UFTaBXup8AkXoyVd/QDiuGLIe+N+eo//6PxghJY39AvwF/s2YHv4mGnUO1mMpHGyROAyL42bhkeVzhnN02x34iyrEUxN9Dr3waEqUqcHgNEfg5MxNvyVMftp6w9b5m6wypm5wAPzf3ZNDPh/fWdGDkHtzwj7Q4wgTorpuJt185PqIu6qUhWTbqlGIWTBrvMjwEKJrOANFO49n+rbqMiLIkdLRdcPPC+5Ru8mzA4w7Z/LVPK/3K8msVJ2bWMXTYqnE8val07sLzoUacNcjQIDAQAB";

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = "";

        return config;
    }
}
