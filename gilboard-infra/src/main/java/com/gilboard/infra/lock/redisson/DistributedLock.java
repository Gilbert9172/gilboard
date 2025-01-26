package com.gilboard.infra.lock.redisson;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DistributedLock {

    String value();

    long waitTime() default 5000L;

    long leaseTime() default 2000L;

}
