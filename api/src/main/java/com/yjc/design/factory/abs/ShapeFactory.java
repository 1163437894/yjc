package com.yjc.design.factory.abs;

import java.util.HashMap;
import java.util.Map;

/**
 * 形状抽象工厂
 *
 * @author yjc
 */
public class ShapeFactory extends AbstractFactory {

    private static Map<Integer, Shape> map = new HashMap<>(16);

    static {
        map.put(ShapeFactoryType.SQUARE.type, new SquareImpl());
        map.put(ShapeFactoryType.CIRCLE.type, new CircleImpl());
    }


    @Override
    public Shape getShape(int type) {
        return map.get(type);
    }


    enum ShapeFactoryType {

        SQUARE(1), CIRCLE(2);

        int type;

        ShapeFactoryType(int type) {
            this.type = type;
        }

    }
}
