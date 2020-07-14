package com.yjc.design.factory.abs;


/**
 * 测试
 *
 * @author yjc
 */
public class AbstractTest {

    public static void main(String[] args) {
//        color();
        shape();
    }

    private static void color() {

        //正常流程
//        ColorFactory colorFactory = new ColorFactory();
//        Color color = colorFactory.getColor(ColorFactory.ColorFactoryType.BLUE.type);
//        String blue = color.getColor();
//        System.out.println(blue);

        //无法直接调用获取形状， 抛出异常
        AbstractFactory colorFactory = new ColorFactory();
        Shape shape = colorFactory.getShape(1);

        System.out.println(shape.getShape());

    }

    private static void shape() {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(ShapeFactory.ShapeFactoryType.SQUARE.type);
        System.out.println(shape.getShape());
    }
}
