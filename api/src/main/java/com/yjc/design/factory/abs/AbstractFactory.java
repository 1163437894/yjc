package com.yjc.design.factory.abs;

/**
 * 抽象工厂类
 *
 * @author yjc
 */
public abstract class AbstractFactory {

    /**
     * 获取形状
     *
     * @return
     */
    public Shape getShape(int type) {
        throw new NullPointerException("无法获取形状");
    }


    /**
     * 获取颜色
     *
     * @return
     */
    public Color getColor(int type) {
        throw new NullPointerException("无法获取颜色");
    }
}
