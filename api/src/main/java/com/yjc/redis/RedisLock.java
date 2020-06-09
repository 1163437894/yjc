package com.yjc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;

@Component
public class RedisLock {

    private final StringRedisTemplate redisTemplate;

    private final RedisScript<Boolean> releaseScript;

    @Autowired
    public RedisLock(StringRedisTemplate redisTemplate, RedisScript<Boolean> releaseScript) {
        this.redisTemplate = redisTemplate;
        this.releaseScript = releaseScript;
    }

    /**
     * 获取锁
     *
     * @param key    key
     * @param token  上锁 token
     * @param expire 过期时间
     * @return true or false
     */
    Boolean getLock(String key, String token, int expire) {
        return redisTemplate.opsForValue().setIfAbsent(key, token, Duration.ofSeconds(expire));
    }

    /**
     * 释放锁
     *
     * @param key   key
     * @param token token
     */
    Boolean releaseLock(String key, String token) {
        return redisTemplate.execute(releaseScript, Collections.singletonList(key), token);
    }

}
