package com.yjc.design.builder;

/**
 * 瓶子实现类
 *
 * @author yjc
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
