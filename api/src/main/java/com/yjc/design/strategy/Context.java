package com.yjc.design.strategy;

/**
 * 维护策略模式的引用
 *
 * @author yjc
 */
public class Context {


    private Strategy strategy;


    public Context(StrategyType type) {
        switch (type) {
            case TYPE_A:
                this.strategy = new MethodAStrategy();
                break;
            case TYPE_B:
                this.strategy = new MethodBStrategy();
                break;
            case TYPE_C:
                this.strategy = new MethodCStrategy();
                break;
            default:
                this.strategy = null;
                break;
        }
    }


    /**
     * 方法实现
     *
     * @param param 参数
     * @return
     */
    public String methodImpl(String param) {
        return strategy.getMethod(param);
    }


    enum StrategyType {
        TYPE_A(1), TYPE_B(2), TYPE_C(3);


        private Integer type;


        StrategyType(Integer type) {
            this.type = type;
        }

        public static Integer getType(Integer type) {
            for (StrategyType value : values()) {
                if (value.type.equals(type)) {
                    return value.type;
                }
            }
            return null;
        }

    }


}
