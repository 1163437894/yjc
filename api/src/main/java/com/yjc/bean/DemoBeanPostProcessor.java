package com.yjc.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


@Slf4j
public class DemoBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if ("demoBean".equals(beanName)) {
            log.info("--> BeanPostProcessor.postProcessAfterInitialization");
        }

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if ("demoBean".equals(beanName)) {
            log.info("--> BeanPostProcessor.postProcessBeforeInitialization");
        }
        return bean;
    }
}
