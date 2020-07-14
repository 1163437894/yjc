package com.yjc.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

@Slf4j
public class DemoBean implements InitializingBean {

    public DemoBean() {
        log.info("--> instantiate ");
    }


    @PostConstruct
    public void postConstruct() {
        log.info("--> postConstruct");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("--> initializingBean afterPropertiesSet");
    }


    public void initMethod() {
        log.info("--> custom initMethod");
    }
}
