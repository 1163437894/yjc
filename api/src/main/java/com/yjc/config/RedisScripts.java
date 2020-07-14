package com.yjc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.script.RedisScript;

@Configuration
public class RedisScripts {

    @Bean
    public RedisScript releaseLockScript() {
        return RedisScript.of("if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end", Boolean.class);
    }

}
