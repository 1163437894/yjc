package com.yjc.design.builder;

/**
 * 汉堡实现类2
 *
 * @author yjc
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public Integer price() {
        return 2;
    }

}
