package com.yjc.design.strategy;

/**
 * 策略实现类C
 *
 * @author yjc
 */
public class MethodCStrategy implements Strategy {
    @Override
    public String getMethod(String param) {
        return "实现类B,参数：" + param;
    }
}
