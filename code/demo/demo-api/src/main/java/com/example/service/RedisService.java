package com.example.service;

public interface RedisService {
    boolean set(String key, Object value);

    Object get(String key);

    void del(String... key);

    boolean hasKey(String key);

    // 指定失效时间
    boolean expire(String key, long time);
}
