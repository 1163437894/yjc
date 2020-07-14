package com.yjc.design.builder;

/**
 * 冷饮类目
 *
 * @author yjc
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract Integer price();
}
