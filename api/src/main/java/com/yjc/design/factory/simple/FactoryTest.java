package com.yjc.design.factory.simple;


/**
 * 工厂测试
 */
public class FactoryTest {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        String circle = factory.getShape(ShapeFactory.ShapeFactoryType.CIRCLE);
        System.out.println(circle);
        String square = factory.getShape(ShapeFactory.ShapeFactoryType.SQUARE);
        System.out.println(square);
    }
}
