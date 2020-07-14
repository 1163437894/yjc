package com.yjc.design.factory.abs;


import java.util.HashMap;
import java.util.Map;

/**
 * 颜色工厂
 *
 * @author yjc
 */
public class ColorFactory extends AbstractFactory {

    private static Map<Integer, Color> map = new HashMap<>(16);

    static {
        map.put(ColorFactoryType.RED.type, new RedImpl());
        map.put(ColorFactoryType.BLUE.type, new BlueImpl());
    }

    @Override
    public Color getColor(int type) {
        return map.get(type);
    }


    enum ColorFactoryType {
        RED(1), BLUE(2);

        int type;

        ColorFactoryType(int type) {
            this.type = type;
        }
    }
}
