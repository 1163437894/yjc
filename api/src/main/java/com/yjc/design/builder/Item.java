package com.yjc.design.builder;


/**
 * 食物条目
 *
 * @author yjc
 */
public interface Item {


    /**
     * 名称
     *
     * @return
     */
    String name();

    /**
     * 包装
     *
     * @return
     */
    Packing packing();

    /**
     * 价格
     *
     * @return
     */
    Integer price();
}
