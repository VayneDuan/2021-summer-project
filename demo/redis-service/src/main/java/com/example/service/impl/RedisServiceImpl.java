package com.example.service.impl;

import com.example.service.RedisService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service(version ="1.0.0")
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    @Override
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
