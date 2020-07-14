package com.yjc.design.strategy;

/**
 * 策略调用
 *
 * @author yjc
 */
public class StrategyTest {
    public static void main(String[] args) {
        Context context = new Context(Context.StrategyType.TYPE_A);
        String impl = context.methodImpl("策略模式");
        System.out.println(impl);
    }
}
