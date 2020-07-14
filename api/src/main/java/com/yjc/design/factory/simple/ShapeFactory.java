package com.yjc.design.factory.simple;

/**
 * 形状工厂
 *
 * @author yjc
 */
public class ShapeFactory {

    public String getShape(ShapeFactoryType type) {

        String msg;
        switch (type) {
            case SQUARE:
                SquareImpl square = new SquareImpl();
                msg = square.getShape();
                break;
            case CIRCLE:
                CircleImpl circle = new CircleImpl();
                msg = circle.getShape();
                break;
            default:
                msg = "未找到图形";
                break;
        }

        return msg;
    }


    enum ShapeFactoryType {
        SQUARE(1), CIRCLE(2);

        private int type;

        ShapeFactoryType(int type) {
            this.type = type;
        }
    }

}
