package com.yjc.config;


import com.yjc.bean.DemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean(initMethod = "initMethod")
    public DemoBean demoBean() {
        return new DemoBean();
    }
}
