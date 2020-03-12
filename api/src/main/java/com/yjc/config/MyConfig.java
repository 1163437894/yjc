package com.yjc.config;

import com.yjc.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yjc
 */
@Configuration
public class MyConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }
}
