package com.yjc.design.single;

/**
 * 单例demo
 */
public class SingleTest {


    public static void main(String[] args) {
        singleTest();
        singleTest();
        singleSyncTest();
        singleSyncTest();
        hungryTest();
        hungryTest();
    }


    public static void singleTest() {
        LazyTest lazy = LazyTest.getLazy();
        System.out.println(lazy);
    }

    public static void singleSyncTest() {
        LazyTest sync = LazyTest.getLazySync();
        System.out.println(sync);
    }

    public static void hungryTest() {
        HungryTest hungry = HungryTest.getHungry();
        System.out.println(hungry);
    }
}
