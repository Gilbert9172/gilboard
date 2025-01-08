package com.gilboard.infra.cache.redis.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("spring.data.redis")
public class RedisProperty {
    private String host;
    private int port;
}
