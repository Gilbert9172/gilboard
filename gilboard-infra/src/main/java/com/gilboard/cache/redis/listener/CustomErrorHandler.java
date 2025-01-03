package com.gilboard.cache.redis.listener;

import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class CustomErrorHandler implements ErrorHandler {

    private CustomErrorHandler() {
    }

    public static CustomErrorHandler newOne() {
        return new CustomErrorHandler();
    }

    @Override
    public void handleError(Throwable t) {
        System.out.printf("에러 발생 = {%s}", t.getMessage());
    }
}
