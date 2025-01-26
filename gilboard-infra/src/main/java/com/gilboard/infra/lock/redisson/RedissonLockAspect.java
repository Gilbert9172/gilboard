package com.gilboard.infra.lock.redisson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class RedissonLockAspect {

    private final RedissonClient redissonClient;

    @Pointcut("@annotation(com.gilboard.infra.lock.redisson.DistributedLock)")
    public void redissonLockPointcut() {
    }

    @Around("redissonLockPointcut()")
    public Object redissonLock(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        DistributedLock annotation = method.getAnnotation(DistributedLock.class);
        String lockKey = method.getName() + getDynamicValue(signature.getParameterNames(), joinPoint.getArgs(), annotation.value());
        log.info("Lock Key={}", lockKey);

        RLock lock = redissonClient.getLock(lockKey);

        boolean isLocked = false;
        try {
            // 락 획득 시도
            isLocked = lock.tryLock(annotation.waitTime(), annotation.leaseTime(), TimeUnit.MILLISECONDS);
            if (!isLocked) {
                log.info("Lock 획득 실패: {}", lockKey);
                return null;
            }
            log.info("Lock 획득 성공: {}", lockKey);
            registerLockReleaseAfterTransaction(lock);
            return joinPoint.proceed();

        } catch (InterruptedException e) {
            log.error("Lock 획득 중 에러 발생: {}", lockKey, e);
            throw e;
        }
    }

    private void registerLockReleaseAfterTransaction(RLock lock) {
        // 트랜잭션 동기화를 통해 커밋 이후 락 해제
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                log.info("Transaction Commit 완료 후 Lock 해제");
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    log.info("Lock 해제 성공");
                }
            }

            @Override
            public void afterCompletion(int status) {
                if (status != TransactionSynchronization.STATUS_COMMITTED) {
                    // 롤백의 경우에도 락 해제를 시도
                    log.warn("Transaction 롤백으로 인한 Lock 해제 시도");
                    if (lock.isHeldByCurrentThread()) {
                        lock.unlock();
                        log.info("Lock 해제 성공 (롤백)");
                    }
                }
            }
        });
    }

    private Object getDynamicValue(String[] parameterNames, Object[] args, String key) {
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }

        return parser.parseExpression(key).getValue(context, Object.class);
    }

}
