package com.gilboard.infra.cache.redis.listener;

import com.gilboard.infra.cache.CacheClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisKeyExpiredListener implements MessageListener {

    private final CacheClient cacheClient;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println(message.toString());
        System.out.print("DB Insert 동작");
    }
}
