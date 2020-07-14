package com.yjc.design.builder;

/**
 * 汉堡类目
 *
 * @author yjc
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract Integer price();

}
