package com.yjc.design.strategy;

/**
 * 策略模式实现类A
 *
 * @author yjc
 */
public class MethodAStrategy implements Strategy {
    @Override
    public String getMethod(String param) {

        return "实现类A,参数：" + param;
    }
}
