package com.yjc.design.strategy;

/**
 * 策略实现类B
 *
 * @author yjc
 */
public class MethodBStrategy implements Strategy {
    @Override
    public String getMethod(String param) {
        return "实现类B,参数：" + param;
    }
}
