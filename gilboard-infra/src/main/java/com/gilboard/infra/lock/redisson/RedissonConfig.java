package com.gilboard.infra.lock.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() throws IOException {
        ClassPathResource resource = new ClassPathResource("application-redisson.yml");
        Config config = Config.fromYAML(resource.getInputStream());
        return Redisson.create(config);
    }
}
