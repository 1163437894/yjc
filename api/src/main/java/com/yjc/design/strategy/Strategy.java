package com.yjc.design.strategy;


/**
 * 策略模式主接口
 *
 * @author yjc
 */
public interface Strategy {


    /**
     * 获取方法
     *
     * @param param 参数
     * @return
     */
    String getMethod(String param);

}
