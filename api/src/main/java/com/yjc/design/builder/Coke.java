package com.yjc.design.builder;

/**
 * 冷饮实现类1
 *
 * @author yjc
 */
public class Coke extends ColdDrink {


    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public Integer price() {
        return 1;
    }
}
