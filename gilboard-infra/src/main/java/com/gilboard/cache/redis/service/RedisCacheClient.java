package com.gilboard.cache.redis.service;

import com.gilboard.cache.CacheClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisCacheClient implements CacheClient {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public <T> void saveValueOfString(String key, T value, Duration duration) {
        redisTemplate.opsForValue().set(key, value, duration);
    }
}
