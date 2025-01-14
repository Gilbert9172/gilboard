package com.gilboard.domain.referral.model;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import static lombok.AccessLevel.PRIVATE;

@Component
@NoArgsConstructor(access = PRIVATE)
public class TimeBasedCodeGenerator implements StringGenerator {

    @Override
    public String generateRandomString() {
        long timestamp = Instant.now().toEpochMilli();
        int random = ThreadLocalRandom.current().nextInt(1000, 9999);
        return Long.toString(timestamp, 36) + random;
    }

}
