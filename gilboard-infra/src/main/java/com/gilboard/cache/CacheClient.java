package com.gilboard.cache;

import java.time.Duration;

public interface CacheClient {
    <T> void saveValueOfString(String key, T value, Duration duration);

    <T> T findFromString(String key, Class<T> clazz);
}
