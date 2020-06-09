package com.yjc.aop;


import com.yjc.anno.Lock;
import com.yjc.exception.RedisLockException;
import com.yjc.redis.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class RedisLockAspect {

    private final RedisLock redisLock;

    /**
     * 锁最大过期时间，单位秒
     */
    private final static int MAX_EXPIRE_TIME = 30;
    /**
     * 锁前缀
     */
    private final static String LOCK_KEY_PREFIX = "lock:";


    @Autowired
    public RedisLockAspect(RedisLock redisLock) {
        this.redisLock = redisLock;
    }

    @Pointcut("@annotation(com.yjc.anno.Lock)")
    public void redisLock() {
    }


    @Around("redisLock()")
    public void around(ProceedingJoinPoint pjp) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        Lock lock = method.getAnnotation(Lock.class);

        if (validLock(lock)) {

            //锁key
            String key = getLockKey(lock.key(), pjp);


        }
    }


    /**
     * 加锁
     *
     * @param key
     * @param pjp
     */
    public String getLockKey(String key, ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String name = signature.getName();
        return LOCK_KEY_PREFIX + name + key;
    }


    /**
     * 验证是否可以加锁
     *
     * @param lock
     * @return
     */
    public boolean validLock(Lock lock) {

        if (StringUtils.isBlank(lock.key())) {
            return false;
        }

        if (lock.expire() > MAX_EXPIRE_TIME) {
            throw new RedisLockException("锁过期时间超过了最大过期时间,当前过期时间:" + lock.expire() + ",最大过期时间:" + MAX_EXPIRE_TIME);
        }

        return true;
    }
}
