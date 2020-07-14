package com.yjc.design.single;

/**
 * 恶汉式
 *
 * @author yjc
 */
public class HungryTest {
    private static HungryTest hungryTest = new HungryTest();

    private HungryTest() {

    }

    public static HungryTest getHungry() {
        return hungryTest;
    }
}
