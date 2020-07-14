package com.yjc.design.builder;

/**
 * 汉堡实现类
 *
 * @author yjc
 */
public class VegBurger extends Burger {


    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public Integer price() {
        return 1;
    }
}
