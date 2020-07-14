package com.yjc.design.builder;

/**
 * 冷饮实现2
 *
 * @author yjc
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public Integer price() {
        return 2;
    }
}
